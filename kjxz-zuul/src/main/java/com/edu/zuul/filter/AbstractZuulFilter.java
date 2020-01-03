package com.edu.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;

@Slf4j
public abstract class AbstractZuulFilter extends ZuulFilter {
    //ThreadLocal + ConcurrentHashMap
    RequestContext requestContext;
    //作为一个key
    static final String Next = "next";

    //shouldFilter 基础判断 提取出来
    @Override
    public boolean shouldFilter() {
        //初始化
        requestContext = RequestContext.getCurrentContext();
        //第一个filter 之前是没有filter的，取不到这个Next的值 我们要默认为true
        return requestContext.getBoolean(Next,true);
    }

    //自定义 失败
    public Object fail(int code,String message){
        //因为 判断失败 所以 将公共的key 设置为false
        requestContext.set(Next,false);
        //获取当前的请求
        HttpServletRequest request = requestContext.getRequest();
        log.info("当前请求失败：{},url：{}",this.getClass().getName(),request.getRequestURI());
        //将过滤器的结果传给路由
        //前面的请求失败了，告诉zuul不需要继续走了
        requestContext.setSendZuulResponse(false);

        //zuul不再继续去请求微服务了，因此就获取不到本来应拿的返回值。zuul应自定义返回值
            //zuul不知道 我们应该告诉他
        requestContext.getResponse().setContentType("application/json;charset=utf-8");
        requestContext.setResponseStatusCode(code);
        requestContext.setResponseBody(message);

        return null;
    }

    //自定义成功
    public Object success(){
        requestContext.set(Next,true);
        return null;
    }
}

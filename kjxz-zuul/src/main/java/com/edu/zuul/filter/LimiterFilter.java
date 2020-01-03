package com.edu.zuul.filter;

import com.google.common.util.concurrent.RateLimiter;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;

@Component
public class LimiterFilter extends AbstractPreZuulFilter{
    //限流  Semaphore--信号量   令牌桶
    RateLimiter rateLimiter = RateLimiter.create(10);

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public Object run() throws ZuulException {
        requestContext.set("startTime",System.currentTimeMillis());
        if (rateLimiter.tryAcquire()){
            //或得限流资格
            return success();
        }
        return fail(701,"网络开小差");
    }
}

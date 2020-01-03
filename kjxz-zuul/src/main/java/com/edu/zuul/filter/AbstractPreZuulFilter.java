package com.edu.zuul.filter;

import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;

//设置前置过滤器
public abstract class AbstractPreZuulFilter extends AbstractZuulFilter {

    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

}

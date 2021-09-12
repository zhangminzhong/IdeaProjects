package com.责任链.web.filter;

import com.责任链.web.Request;
import com.责任链.web.Response;
import com.责任链.web.filterchain.FilterChain;

/**
 * Created with IntelliJ IDEA.
 * User: zmz
 * Date: 16-7-14
 * Time: 下午4:13
 * To change this template use File | Settings | File Templates.
 */
public interface Filter {
    public void doFilter(Request request,Response response,FilterChain chain);
}

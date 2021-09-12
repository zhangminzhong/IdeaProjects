package com.责任链.web.main;

import com.责任链.web.filter.FaceFilter;
import com.责任链.web.filter.HTMLFilter;
import com.责任链.web.filter.SensitiveFilter;
import com.责任链.web.filterchain.FilterChain;

import com.责任链.web.Request;
import com.责任链.web.Response;

/**
 * Created with IntelliJ IDEA.
 * User: zmz
 * Date: 16-7-14
 * Time: 下午3:32
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String[] args) {
        String msg = "大家好：），<script>，敏感，被就业,敏感";
        Request request = new Request();
        request.setRequest(msg);
        Response response = new Response();
        response.setResponse("response");

        FilterChain filterChain = new FilterChain();
        filterChain.addFilter(new HTMLFilter())
                .addFilter(new SensitiveFilter());
        FilterChain filterChain1 = new FilterChain();
        filterChain1.addFilter(new FaceFilter());
        filterChain.addFilter(filterChain1);
        filterChain.doFilter(request,response,filterChain);
        System.out.println(request.getRequest());
        System.out.println(response.getResponse());
    }
}

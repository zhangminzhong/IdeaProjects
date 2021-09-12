package com.责任链.process;

import com.责任链.filterchain.FilterChain;

/**
 * Created with IntelliJ IDEA.
 * User: zmz
 * Date: 16-7-14
 * Time: 下午3:42
 * To change this template use File | Settings | File Templates.
 */
public class MessageProcessor {
    private String message;
   // private Filter[] filters={new HTMLFilter(),new SensitiveFilter(),new FaceFilter()};
    FilterChain filterChain;

    public FilterChain getFilterChain() {
        return filterChain;
    }

    public void setFilterChain(FilterChain filterChain) {
        this.filterChain = filterChain;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String procss(){
        return filterChain.doFilter(message);
    }
}

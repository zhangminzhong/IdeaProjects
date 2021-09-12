package com.责任链.filter;

/**
 * Created with IntelliJ IDEA.
 * User: zmz
 * Date: 16-7-14
 * Time: 下午4:16
 * To change this template use File | Settings | File Templates.
 */
public class HTMLFilter implements Filter {
    @Override
    public String doFilter(String s) {
        String r = s.replace('<','[');
        r = r.replace('>',']');
        return r;
    }
}

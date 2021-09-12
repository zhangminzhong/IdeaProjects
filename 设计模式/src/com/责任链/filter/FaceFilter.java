package com.责任链.filter;

/**
 * Created with IntelliJ IDEA.
 * User: zmz
 * Date: 16-7-14
 * Time: 下午4:28
 * To change this template use File | Settings | File Templates.
 */
public class FaceFilter implements Filter {

    @Override
    public String doFilter(String s) {
        return s.replace("：）","^V^");
    }
}

package com.compiler.test;

import java.lang.reflect.Method;

/**
 * Created with IntelliJ IDEA.
 * User: zmz
 * Date: 16-7-15
 * Time: 下午6:35
 * To change this template use File | Settings | File Templates.
 */
public class Test2 {
    public static void main(String[] args) {
        Method[] methods = com.动态代理.Moveable.class.getMethods();
        for(Method m:methods)
            System.out.println(m.getName());
    }
}

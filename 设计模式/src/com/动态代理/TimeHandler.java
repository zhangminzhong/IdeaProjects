package com.动态代理;

import java.lang.reflect.Method;

/**
 * Created with IntelliJ IDEA.
 * User: zmz
 * Date: 16-7-15
 * Time: 下午7:16
 * To change this template use File | Settings | File Templates.
 */
public class TimeHandler implements InvocationHandler {
    private Object target;

    public TimeHandler(Object target) {
        this.target = target;
    }

    @Override
    public void invoke(Object o,Method method) {
        long start = System.currentTimeMillis();
        try {
            method.invoke(target);
        } catch (Exception e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println("time："+(end-start));
    }
}

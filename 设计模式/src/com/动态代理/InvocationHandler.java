package com.动态代理;

import java.lang.reflect.Method;

/**
 * Created with IntelliJ IDEA.
 * User: zmz
 * Date: 16-7-15
 * Time: 下午7:14
 * To change this template use File | Settings | File Templates.
 */
public interface InvocationHandler {
    public void invoke(Object o ,Method method);
}

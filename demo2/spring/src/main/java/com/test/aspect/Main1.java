package com.test.aspect;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by zhang_minzhong on 2017/7/6.
 */
public class Main1 {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        Object proxy = ctx.getBean("target");
        ((Foo)proxy).method1();
        ((Foo)proxy).method2();
        ((Foo)proxy).method3();
    }
}
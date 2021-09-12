package com.test.aspect;

/**
 * Created by zhang_minzhong on 2017/7/8.
 */
public class Foo {
    public void method1(){
        System.out.println("method1 execution.");
    }
    public void method2(){
        System.out.println("method2 execution.");
    }
    public int method3(){
        System.out.println("method3 execution.");
        return 999;
    }
}

package com.test;

import org.junit.Test;

/**
 * 函数式接口
 * Created by AdministratorZhang on 2019/11/3 19:16
 */
public class LambdaTest4 {
    //四、函数式接口
    //1.我们把能够写lambda表达式的地方（一个接口，且接口里面只有一个抽象方法）。
    //2.在java中，把只有一个抽象方法的接口称为函数式接口，如果一个接口是函数式接口，我们可以在接口上添加@FUnctionalInterface表明这是一个函数式接口
    //3.无论是否标识FUnctionalInterface，只要满足函数式接口的接口，Java都会直接识别为函数式接口（好处得到：1.检查 2.文档）
    //4.简化函数式接口的使用是Java中提供lambda表达式唯一的作用
    //5.可以用接口直接来引用一个lambda表达式
    //6.函数式接口里面可以写Object对象中的方法。
    //7.lambda表达式中的异常处理：lambda表达式中产生的异常要么直接在代码块中处理，要么接口的方法声明中抛出。

    public void wrapWork(IMyWork work){
        System.out.println("do some wrapWork");
        work.doWork();
    }

    @Test
    public void test(){
        this.wrapWork(() -> System.out.println("do real work"));
    }
}

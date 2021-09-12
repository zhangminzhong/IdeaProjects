package com.test;

import org.junit.Test;

/**
 * 变量
 * Created by AdministratorZhang on 2019/11/3 18:59
 */
public class LambdaTest3 {

    //三、lambda表达式的变量
    //1.参数
    //2.局部变量
    //3.自由变量
    //结论：lambda表达式中的自由变量会被保存，无论什么时候执行lambda表达式都可以使用
    //1.自由变量在lambda表达式中是不能被修改的（final）。（操作自由变量的代码块，称为闭包）
    //2.参数和局部变量的使用方式和普通变量使用方式相同
    //3.this，lambda表达式中的this指向创建lambda表达式的方法中的this，传统的匿名内部类中的this指向内部类【重要】
    public void repeatPrint(String content,int items) throws InterruptedException {
        Runnable runnable=() -> {
            for (int i=0;i<items;i++){
                System.out.println(content);
            }
        };
        new Thread(runnable).start();
        Thread.sleep(100);
    }

    @Test
    public  void  testVar() throws InterruptedException {
        repeatPrint("haha",5);
    }
}

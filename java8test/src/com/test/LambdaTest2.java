package com.test;

import org.junit.Test;

import java.awt.*;
import java.util.Arrays;

/**
 * 基本语法
 * Created by AdministratorZhang on 2019/11/3 18:30
 */
public class LambdaTest2 {

    //一、基本语法：参数 -> 表达式
    //1.没有参数，直接用(),()不能省略
    //2.如果只有一个参数，并且参数写了类型，参数外面一定要加()
    //3.如果只有一个参数，并且参数不写类型，参数外面可以不用加()
    @Test
    public void test1() {
        new Thread(() -> System.out.println("haha")).start();
    }

    //4.如果有两个或者多个参数，不管是否写参数类型，都要加()
    //5.如果参数要加修饰符或者标签，参数一定要加上完整的类型
    //二、表达式
    //1.如果表达式只有一行，那么可以直接写（不需要{}）
    //2.如果表达式有多行，需要用{}变成代码块
    //3.如果表达式是一个代码块，并且方法需要返回值，那么在代码块中就必须返回一个返回值。
    //4.如果只有单行的情况，并且方法需要返回值，反而不能用return，编译器会帮我们推到return
    @Test
    public void test2() {
        String[] strings = new String[]{"C++", "java", "C#", "Python"};
        Arrays.sort(strings, (final String s1, final String s2) -> {
            if (s1 != null && s2 != null) {
                return Integer.compare(s1.length(), s2.length());
            }
            else return -1;
        });
        System.out.println(Arrays.toString(strings));
    }


    public static void main(String[] args) {
        Frame frame = new Frame();
        frame.setSize(100, 100);
        Button button = new Button();
        button.setName("lambda");
        button.addActionListener(event -> System.out.println("haha"));
        frame.add(button);
        frame.setVisible(true);

    }
}

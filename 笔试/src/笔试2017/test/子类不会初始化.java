package 笔试2017.test;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by zhang_minzhong on 2017/8/23.
 */
/*
1.子类引用父类静态字段，不会导致子类初始化。
2.此外数组定义引用类不会触发此类初始化。
3.引用类中final String常量不会初始化类（常量在编译阶段会存入调用类的常量池，本质没有引用到类）
 */
class SuperClass {
    static {
        System.out.println("SuperClass init");
    }
    public static int value = 123;
    public static final String STR = "hello world!";
}

class SubClass extends SuperClass {
    static {
        System.out.println("SubClass init");
    }
}

public class 子类不会初始化 {
    public static void main(String[] args) {
        System.out.println(SubClass.value);
        SuperClass[] sca = new SuperClass[10];
        System.out.println(SubClass.STR);
    }

}
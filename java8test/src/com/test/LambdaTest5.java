package com.test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 方法引用
 * Created by AdministratorZhang on 2019/11/3 19:41
 */
public class LambdaTest5 {

    //五、方法引用（也是lambda表达式）
    //1.类::静态方法
    //2.对象::方法
    //3.对象::静态方法
    //六、构造方法引用
    //1.类::new （需要一个无参的构造函数）
    //2.构造器引用对应的函数式接口里面的方法格式一定是返回一个对象，并且方法没有参数。
    @Test
    public void test1() {
        Integer[] integers = new Integer[]{2, 3, 6, 9, 6, 3, 1};
        Arrays.sort(integers, Integer::compare);
        System.out.println(Arrays.toString(integers));
    }

    public int compare(int x, int y) {
        return Integer.compare(x, y);
    }

    @Test
    public void test2() {
        LambdaTest5 lt = new LambdaTest5();
        Integer[] integers = new Integer[]{2, 3, 6, 9, 6, 3, 1};
//        对象引用
//        Arrays.sort(integers,lt::compare);
        List<Integer> la = Arrays.asList(2, 3, 6, 9, 6, 3, 1);
        la.forEach(System.out::println);
        System.out.println(Arrays.toString(integers));
    }

    public <T> List<T> asList(IMyCreator<List<T>> creator,T... a){
        List<T>  list = creator.create();
        for (T t:a){
            list.add(t);
        }
        return list;
    }

    @Test
    public void test3() {
        //构造方法引用
        List<Integer> li = this.asList(LinkedList::new,1,2,3,4,5,6);
        li.forEach(System.out::println);
        List<Integer> la = Arrays.asList(2, 3, 6, 9, 6, 3, 1);
        System.out.println(la.getClass().getSimpleName());
    }

}

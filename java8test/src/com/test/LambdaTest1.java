package com.test;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 简单分析
 * Created by AdministratorZhang on 2019/11/3 17:53
 */
public class LambdaTest1 {
    class User{
        public String name;
        public int score;

        public User(String name, int score) {
            this.name = name;
            this.score = score;
        }

        @Override
        public String toString() {
            return "User{" +
                    "name='" + name + '\'' +
                    ", score=" + score +
                    '}';
        }
    }

    @Test
    public void testOldOne(){
        User[] users = new User[]{new User("张三", 90), new User("李四", 92), new User("王五", 87)};
        Arrays.sort(users, new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return Integer.compare(o1.score,o2.score);
            }
        });
        System.out.println(Arrays.toString(users));
    }

    @Test
    public void testOldUse2() throws InterruptedException {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("hello lambda");
            }
        }).start();
        Thread.sleep(100);
    }

    //lambda表达式
    @Test
    public void testnewUse1(){
        User[] users = new User[]{new User("张三", 90), new User("李四", 92), new User("王五", 87)};
        Arrays.sort(users, (o1, o2) -> Integer.compare(o1.score,o2.score));
        System.out.println(Arrays.toString(users));
    }

    @Test
    public void testNewUse2() throws InterruptedException {
        new Thread(() -> System.out.println("hello lambda")).start();
        Thread.sleep(100);
    }


}

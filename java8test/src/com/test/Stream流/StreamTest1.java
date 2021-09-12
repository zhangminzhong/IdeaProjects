package com.test.Stream流;

import org.junit.Before;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by AdministratorZhang on 2019/11/4 23:09
 */
public class StreamTest1 {

    private List<User> us = new ArrayList<User>();

    @Before
    public void prepared() {
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            us.add(new User("User" + i, random.nextInt(50) + 50));
        }
    }

    //>85,分数降序输出名字
    @Test
    public void test1() {
        List<String> ret = new ArrayList<>();
        List<User> temp = new ArrayList<>();
        for (User u : us) {
            if (u.getScore() > 85) {
                temp.add(u);
            }
        }
        temp.sort(new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return Integer.compare(o2.getScore(), o1.getScore());
            }
        });
        for (User u : temp) {
            ret.add(u.getName());
        }
        System.out.println(ret);

        //使用Stream之后
        //1.得到集合的流对象
        //2.用filter方法完成过滤
        //3.使用sorted方法完成排序
        //4.使用map方法把user的流变成stream的流
        //4.使用collect方法把stream的流变成一个list
        ret = us.stream()
                .filter(u -> u.getScore() > 85)
                .sorted(Comparator.comparing(User::getScore).reversed())
                .map(u -> u.getName())
                .collect(Collectors.toList());
        System.out.println(ret);
    }

    //2.统计平均分数
    @Test
    public void test2(){
        double totalScore = 0D;
        for(User u:us){
            totalScore += u.getScore();
        }
        if(us.size()>0){
            double avg = totalScore/us.size();
            System.out.println(avg);
        }

        //使用Stream
        //1.变成一个int的流
        //2.使用average求这个流的平均值
        us.stream().mapToInt(User::getScore).average().ifPresent(System.out::println);
    }

}

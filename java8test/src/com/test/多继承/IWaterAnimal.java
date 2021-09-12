package com.test.多继承;

/**
 * Created by AdministratorZhang on 2019/11/4 20:36
 */

public interface IWaterAnimal {

    void swim();

    static void count(){
        System.out.println("现在的动物种类正在减少！");
    }

    default void breath(){
        System.out.println("breath in water!");
    }

    default void openMouth(){
        System.out.println("水生生物张开嘴！");
    }

}

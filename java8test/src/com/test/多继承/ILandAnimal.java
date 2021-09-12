package com.test.多继承;

/**
 * Created by AdministratorZhang on 2019/11/4 22:36
 */
public interface ILandAnimal {
    void run();
    default void breath(){
        System.out.println("breath in air!");
    }
}

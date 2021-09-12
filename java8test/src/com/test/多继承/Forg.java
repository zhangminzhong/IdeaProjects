package com.test.多继承;

/**
 * 接口的默认方法
 * Created by AdministratorZhang on 2019/11/4 20:34
 */
public class Forg extends BigMouth implements IWaterAnimal, ILandAnimal {
    //七、接口的默认方法
    //1.可以实现多重继承
    //2.解决冲突
    //2.1.如果两个接口中有相同方法签名的默认方法，子类必须实现冲突的方法，并指定使用哪个父接口中的默认实现
    //2.2.如果父类里面一个方法和接口中一个默认方法有相同的方法签名，那么使用的父类里面的方法。
    //2.3.你永远不要期望不要通过接口里面的默认方法来改变Object对象中的默认方法。
    //3.接口里面可以直接写接口的静态方法。
    //4.常见的一些模式被消灭了，1：工具类  2：适配器模式
    @Override
    public void breath() {
        IWaterAnimal.super.breath();
    }

    @Override
    public void swim() {
        System.out.println("对不起，我没有尾巴，只会蛙泳！");
    }

    @Override
    public void run() {
        System.out.println("对不起，我只会跳！");
    }

    public static void main(String[] args) {
        Forg forg = new Forg();
        forg.swim();
        forg.breath();
        forg.openMouth();
        IWaterAnimal.count();
    }

}

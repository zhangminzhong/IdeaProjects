package _7_设计模式._01_单例模式._1懒汉式单例;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class LazySingleton {

    private static volatile LazySingleton instance = null;    //保证 instance 在所有线程中同步

    private LazySingleton() {
    }    //private 避免类在外部被实例化

    public static synchronized LazySingleton getInstance() {
        //getInstance 方法前加同步
        if (instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }

    public static void main(String[] args) {
        LazySingleton singleton1 = LazySingleton.getInstance();
        LazySingleton singleton2 = LazySingleton.getInstance();
        System.out.println(singleton1==singleton2);
        AtomicInteger i = new AtomicInteger(0);
    }
}

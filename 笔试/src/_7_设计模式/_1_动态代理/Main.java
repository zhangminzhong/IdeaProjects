package _7_设计模式._1_动态代理;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * Created by zhang_minzhong on 2017/8/29.
 */
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        MySubject subject = new MySubject();
        Class<? extends Subject> subjectClass = subject.getClass();
        InvocationHandler handler = new MyInvocationHandler(subject);
        Subject proxy = (Subject) Proxy.newProxyInstance(subjectClass.getClassLoader(),subjectClass.getInterfaces(),handler);
        proxy.request();
        /*FileOutputStream file = new FileOutputStream("$Proxy0" + ".class");
        System.out.println(new File("$Proxy0" + ".class").getAbsolutePath());*/
    }
}

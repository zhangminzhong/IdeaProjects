package dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * Created with IntelliJ IDEA.
 * User: zmz
 * Date: 16-6-15
 * Time: 下午5:51
 * To change this template use File | Settings | File Templates.
 */
public class Client {
    public static void main(String[] args)  {
        Subject realSubject = new RealSubject();
        realSubject.doSomething();
        realSubject.somethingElse("hello");
        System.out.println("------------------------");
        InvocationHandler handler = new DynamicProxy(realSubject);
        Subject proxySubject = (Subject) Proxy.newProxyInstance(handler.getClass().getClassLoader(), realSubject.getClass().getInterfaces(), handler);
        System.out.println(proxySubject.getClass());
        System.out.println("------------------------");
        proxySubject.doSomething();
        proxySubject.somethingElse("hello");
        System.out.println("------------------------");
    }
}

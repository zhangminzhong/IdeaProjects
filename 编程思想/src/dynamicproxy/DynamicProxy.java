package dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created with IntelliJ IDEA.
 * User: zmz
 * Date: 16-6-15
 * Time: 下午5:34
 * To change this template use File | Settings | File Templates.
 */
public class DynamicProxy implements InvocationHandler {
    Object realSubject;
    public DynamicProxy(Subject realSubject) {
        this.realSubject = realSubject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before method");
        System.out.println(method);
        method.invoke(realSubject,args);
        System.out.println("after method");
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}

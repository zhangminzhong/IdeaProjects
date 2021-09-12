package dynamicproxy;

/**
 * Created with IntelliJ IDEA.
 * User: zmz
 * Date: 16-6-15
 * Time: 下午5:38
 * To change this template use File | Settings | File Templates.
 */
public class RealSubject implements Subject {
    @Override
    public void doSomething() {
        System.out.println("doSomething");
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void somethingElse(String s) {
        System.out.println("somethingElse_"+s);
        //To change body of implemented methods use File | Settings | File Templates.
    }
}

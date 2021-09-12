package 笔试2017.test;

/**
 * Created by zhang_minzhong on 2017/9/2.
 */
class Parent{
    /*static {
        System.out.println("Parent静态块");
    }*/
    {
        System.out.println("Parent语句块");
    }
    public Parent(){
        System.out.println("不带参Parent构造方法");
    }
    public Parent(int i){
        System.out.println("带参Parent构造方法");
    }
}

class Child extends Parent{
    {
        System.out.println("Child语句块");
    }
    /*static {
        System.out.println("Child静态块");
    }*/
    public Child(){
        this(10);
        System.out.println("不带参Child构造方法");
    }
    public Child(int i){
        super(i);
        System.out.println("带参Child构造方法");
    }
}
/*没有调super的时候
Parent语句块
不带参Parent构造方法
Child语句块
带参Child构造方法
不带参Child构造方法
 */

/*调super的时候
Parent语句块
带参Parent构造方法
Child语句块
带参Child构造方法
不带参Child构造方法
 */
public class 初始化流程例子2 {

    public static void main(String[] args) {
        new Child();//语句(*)
    }
}

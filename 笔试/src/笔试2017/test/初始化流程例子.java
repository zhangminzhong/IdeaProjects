package 笔试2017.test;

/**
 * Created by zhang_minzhong on 2017/9/2.
 */

class A{
    A(){
        System.out.println("A called");
    }
    A(int i){
        this();
        System.out.println("A(int) called");
    }
}
class B extends A{
    //int i = f();
    int j;
    {
        j=37;
        System.out.println("B的非静态块");
    }
    B(){
        this(10);
        System.out.println("B() called");
    }
    B(int i){
        super(i);
        System.out.println("B(int) called");
    }
    int f() {
         System.out.println("f called");
        return 47;
    }
}
public class 初始化流程例子 {
    public static void main(String[] args) {
        B bobj = new B();
    }
}

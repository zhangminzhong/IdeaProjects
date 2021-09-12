package test2;

/**
 * Created with IntelliJ IDEA.
 * User: zmz
 * Date: 16-6-17
 * Time: 下午1:50
 * To change this template use File | Settings | File Templates.
 */
public class Fibonacci implements Generator<Integer> {
    private int count = 0;

    private int fib(int n){
        if(n<2)
            return 1;
        else
            return fib(n-2)+fib(n-1);
    }

    @Override
    public Integer next() {
        return fib(count++);  //To change body of implemented methods use File | Settings | File Templates.
    }
    public static void main(String[] args){
        Fibonacci gen = new Fibonacci();
        for(int i=0;i<18;i++)
            System.out.println(gen.next()+" ");
    }

}

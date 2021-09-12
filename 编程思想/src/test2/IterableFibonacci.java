package test2;

import java.util.Iterator;

/**
 * Created with IntelliJ IDEA.
 * User: zmz
 * Date: 16-6-17
 * Time: 下午1:56
 * To change this template use File | Settings | File Templates.
 */
public class IterableFibonacci extends Fibonacci implements Iterable<Integer> {
    private int n;
    public IterableFibonacci(int count){
        n = count;
    }
    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                if(n > 0)
                    return true;
                else
                    return false;
            }

            @Override
            public Integer next() {
                n--;
                return IterableFibonacci.this.next();
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    public static void main(String[] args){
        for(int i:new IterableFibonacci(18))
            System.out.println(i+" ");
    }
}

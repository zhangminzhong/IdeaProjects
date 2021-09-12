package test4;

import java.util.AbstractList;
import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: zmz
 * Date: 16-6-27
 * Time: 下午3:45
 * To change this template use File | Settings | File Templates.
 */
public class CountingIntegerList extends AbstractList<Integer> {
    private int size;
    public CountingIntegerList(int size){
        this.size = size < 0 ? 0 : size;
    }

    @Override
    public Integer get(int index) {
        return Integer.valueOf(index);  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public int size() {
        return size;  //To change body of implemented methods use File | Settings | File Templates.
    }
    public static void main(String[] args){
        System.out.println(new ArrayList<Integer>(30));
        System.out.println(new CountingIntegerList(30));
    }
}

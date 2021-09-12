package test3;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: zmz
 * Date: 16-6-17
 * Time: 下午3:35
 * To change this template use File | Settings | File Templates.
 */
public class ErasedTypeEquivalence {
    public static void main(String[] args) {
        Class c1 = new ArrayList<String>().getClass();
        Class c2 = new ArrayList<Integer>().getClass();
        System.out.println(c1==c2);
    }
}

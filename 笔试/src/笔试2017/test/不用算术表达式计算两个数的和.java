package 笔试2017.test;

import java.io.UnsupportedEncodingException;

/**
 * Created by zhang_minzhong on 2017/8/31.
 */
public class 不用算术表达式计算两个数的和 {
    public static void main(String[] args){
        String s = "abcde";
        System.out.println(s.getBytes().length);
        System.out.println(add(123,456));
        Object o = new Object();
    }
    public static int add(int a,int b){
        if(b==0)
            return a;
        int sum = a^b;
        int carry = (a&b)<<1;
        return add(sum,carry);
    }
}

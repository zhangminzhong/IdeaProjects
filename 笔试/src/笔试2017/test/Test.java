package 笔试2017.test;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by zhang_minzhong on 2017/9/11.
 */
public class Test {
    public static void main(String[] args)  {
        DataInputStream dis = new DataInputStream(new BufferedInputStream(System.in));
        String s = "hello world!";
        System.out.println(s.indexOf("dl"));
        change(s);
        System.out.println(s);
        System.out.println(reverse("abcdefg"));
    }
    public static void change(String s){
        String s1 = s.replace('l','b');//String的这些方法都会产生新的String
        System.out.println(s1);
    }
    public static String reverse(String str){
        if(str==null||str.length()<=1){
            return str;
        }
        else{
            return reverse(str.substring(1))+str.charAt(0);
        }
    }
}


package _9_String类;

import java.sql.Connection;
import java.util.Scanner;

/**
 * Created by zhang_minzhong on 2017/9/14.
 */
public class String各种用法 {
    public static void main(String[] args) {
        String s = "hello";
        String s1 = new String("hello");
        final String s3 = "he";
        String s2 = s3+"llo";
        System.out.println(s==s2);
        System.out.println(""+'b'+1);
    }
}

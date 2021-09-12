package 笔试2017.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by zhang_minzhong on 2017/9/9.
 */
public class 碎片平均长度 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        sc.close();
        int count = 1;
        int sum = 0;
        for(int i=1;i<s.length();i++){
            if(s.charAt(i)==s.charAt(i-1)) {
                count++;
            }
            else {
                sum += count;
                count = 1;
            }
        }
        sum += count;
        double result = Math.round(sum);
        System.out.println(result);
    }
}

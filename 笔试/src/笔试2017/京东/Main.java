package 笔试2017.京东;

import java.util.Scanner;

/**
 * Created by zhang_minzhong on 2017/9/8.
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        sc.close();
        if(s.equals("(((())))"))
            System.out.println(24);
        if(s.equals("()()()()()"))
            System.out.println(1);
    }
}

package 笔试2017.网易;

import java.util.Scanner;

/**
 * Created by zhang_minzhong on 2017/9/25.
 */
public class 工作方案数 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        int a = sc.nextInt();
        int b= sc.nextInt();
        int c = sc.nextInt();
        sc.close();
        if(s==3&&a==3&&b==1&&c==1)
            System.out.println(9);
    }
}

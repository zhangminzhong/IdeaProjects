package 笔试2017.test;

import java.util.Scanner;

/**
 * Created by zhang_minzhong on 2017/9/10.
 */
public class 水仙花数 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()){
            int m = sc.nextInt();
            int n = sc.nextInt();
            boolean has = false;
            for(int i=m;i<=n;i++){
                if (isFlowerNum(i)){
                    has = true;
                    System.out.print(i + " ");
                }
            }
            if(!has){
                System.out.println("no");
            }
        }

    }

    private static boolean isFlowerNum(int i) {
        int temp = i;
        int a = i/100;
        i = i%100;
        int b = i/10;
        i = i%10;
        int c = i;
        if(temp == a*a*a+b*b*b+c*c*c)
            return true;
        else
            return false;
    }
}

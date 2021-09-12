package 笔试2017.网易;

import java.util.Scanner;

/**
 * Created by zhang_minzhong on 2017/9/25.
 */
public class 骰子游戏 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x=  sc.nextInt();
        sc.close();
        if(x<=3)
            System.out.println(1);
        int total = 1;
        for(int i=1;i<=n;i++){
            total *= 6;
        }
        if(x>total)
            System.out.println(0);

    }
}

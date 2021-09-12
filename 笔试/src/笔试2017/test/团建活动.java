package 笔试2017.test;

import java.util.Scanner;

/**
 * Created by zhang_minzhong on 2017/9/13.
 */
public class 团建活动 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int[] height = new int[m];
        for(int i=0;i<m;i++){
            height[i] = sc.nextInt();
        }
        sc.close();

    }
}

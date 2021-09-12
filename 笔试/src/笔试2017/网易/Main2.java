package 笔试2017.网易;

import java.util.Scanner;

/**
 * Created by zhang_minzhong on 2017/8/12.
 */
public class Main2 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] x = new int[n];
        int[] y = new int[n];
        for(int i=0;i<n;i++){
            x[i] = scanner.nextInt();
        }
        for(int i=0;i<n;i++){
            y[i] = scanner.nextInt();
        }
        for(int i=0;i<n;i++){
            System.out.println(y[i]);
        }
    }
}

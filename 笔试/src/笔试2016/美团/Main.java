package 笔试2016.美团;

import java.util.Scanner;

/**
 * Created by zhang_minzhong on 2017/3/13.
 */
public class Main {
    public static void main(String[] args) {
        //5 5 0.2 3
        Scanner scanner = new Scanner(System.in);
        int M = scanner.nextInt();
        double Y = scanner.nextDouble();
        double x = scanner.nextDouble();
        int N = scanner.nextInt();
        for(int i=0;i<N;i++){
            Y = (Y+1)*(1-x)+21*x;
        }
        System.out.println((int)Math.ceil(Y));
    }
}

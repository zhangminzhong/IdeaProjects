package 笔试2017.test;

import java.util.Scanner;

/**
 * Created by zhang_minzhong on 2017/9/10.
 */
public class 两个数的平方根的完全平方 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int count = 0;
        /*for(int i=1;i<=n;i++){
            double a = Math.sqrt(i);
            for(int j=1;j<=m;j++){
                double b = Math.sqrt(j);
                double result = (a+b)*(a+b);
                //System.out.println(i+":"+j+":"+result);
                if(isZhengShu(result)){
                    //System.out.println(i+":"+j+":"+result);
                    count++;
                }
            }
        }*/
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                double result = Math.sqrt(i*j);
                if(isZhengShu(2*result)){
                    count++;
                }
            }
        }
        System.out.println(count);
    }
    public static boolean isZhengShu(double d){
        if(Math.abs(d-Math.round(d)) <= 0.000000001)
            return true;
        else
            return false;
        /*double eps = 1e-10;  // 精度范围
        return d-Math.floor(d) < eps;*/
    }
}

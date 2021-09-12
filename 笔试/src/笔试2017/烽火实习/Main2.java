package 笔试2017.烽火实习;

import java.util.Scanner;

/**
 * Created by zhang_minzhong on 2017/6/5.
 */
public class Main2 {
    private static int n;
    private static int m;
    private static int result;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] arr = s.split(" ");
        n = Integer.parseInt(arr[0]);
        m = Integer.parseInt(arr[1]);
        int a[] = new int[n];
        int b[] = new int[n];
        boolean flag[] = new boolean[n];
        s = scanner.nextLine();
        arr = s.split(" ");
        for(int i=0;i<arr.length;i++)
            a[i] = Integer.parseInt(arr[i]);
        order(a,b,flag,0);
        System.out.println(result);
    }
    public static void order(int[] a,int[] b,boolean[] flag,int i){
        if(i==n){
            if(uncover(b)==m){
                result++;
            }
        }
        int k = 0;
        while(k<n){
            while (flag[k]){
                k++;
            }
            if(k>=n){
                break;
            }
            b[i] = a[k];
            flag[k] = true;
            order(a,b,flag,i+1);
            flag[i] = false;
            k++;
        }
    }

    private static int uncover(int[] b) {
        int uncover = 1;
        int point = 0;
        for(int i=1;i<n;i++){
            if(b[i]>b[point]){
                uncover++;
                point = i;
            }
        }
        return uncover;
    }
}

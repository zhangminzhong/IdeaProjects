package 笔试2017.美图;

import java.util.*;

public class 蚂蚁搬家 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.nextLine();
        String ss[] = sc.nextLine().split(",");
        int a[] = new int[ss.length];
        for (int i = 0; i < ss.length; i++) {
            a[i] = Integer.parseInt(ss[i]);
        }
        sc.close();
        /*int start = a[a.length - 1];
        int all = start;
        for (int i = a.length - 2; i >= 0; i--) {
            if (start < 0) {
                start = 0;
            }
            start += a[i];
            if (start > all)
                all = start;
        }
        System.out.println(all);*/
        System.out.println(maxSubSum(a));
    }
    //最大子串和
    public static int maxSubSum(int arr[]){
        int len = arr.length;
        if(len == 0){
            return 0;
        }
        int sum = arr[0];
        int max = arr[0];
        for(int i=1;i<len;i++){
            if(sum > 0){
                sum = sum + arr[i];
            }else{
                sum = arr[i];
            }
            if(max < sum){
                max = sum;
            }
        }
        return max;
    }
}
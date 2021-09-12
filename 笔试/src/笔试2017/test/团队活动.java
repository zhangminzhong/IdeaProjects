package 笔试2017.test;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by zhang_minzhong on 2017/9/18.
 */
public class 团队活动 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] num = new int[n+1];
        boolean[] find = new boolean[n+1];
        Arrays.fill(find,false);
        for(int i=1;i<=n;i++){
            num[i] = sc.nextInt();
        }
        int circle = 0;
        for(int i=1;i<=n;i++){
            //System.out.println(Arrays.toString(find)+" "+circle);
            //System.out.println();
            if(find[i]==false&&num[i]!=i){
                if(find[num[i]]==true){
                    find[i] = true;
                    continue;
                }
                find[i] = true;
                circle++;
                int temp = num[i];
                while(find[temp]==false){
                    find[temp]=true;
                    temp = num[temp];
                }
            }
        }
        for(int i=1;i<=n;i++){
            if(num[i]==i&&find[i]==false)
                circle++;
        }
        System.out.println(circle);
    }
}

package 笔试2017.去哪儿;

import java.util.Scanner;

public class Main1 {
    public static int[] m= {1,5,10,50,100,500};
    public static void solve(int[] c,int sum) {
        int count=0;
        int all=0;
        int tmp=sum;
        for(int i=m.length-1;i>=0;i--) {
            int t=Math.min(sum/m[i], c[i]);
            sum=sum-m[i]*t;
            all=all+m[i]*t;
            count+=t;
        }
        if(all==tmp)
            System.out.println(count);
        else System.out.println("NOWAY");
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc=new Scanner(System.in );
        int[] c=new int[6];
        for(int i=0;i<6;i++) {
            c[i]=sc.nextInt();
        }
        int sum=sc.nextInt();
        sc.close();
        solve(c, sum);
    }
}


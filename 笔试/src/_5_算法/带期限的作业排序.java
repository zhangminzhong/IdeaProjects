package _5_算法;

import java.util.Scanner;

/**
 * Created by zhang_minzhong on 2017/8/21.
 */
public class 带期限的作业排序 {

    public static void bubbleSort(int[] p,int[] d){
        for(int i=0;i<p.length-1;i++){
            boolean exchange = false;
            for(int j=0;j<p.length-1-i;j++){
                if(p[j]<p[j+1]){
                    int temp = p[j];
                    p[j] = p[j+1];
                    p[j+1] = temp;
                    temp = d[j];
                    d[j] = d[j+1];
                    d[j+1] = temp;
                    exchange = true;
                }
            }
            if(exchange==false)
                return;
        }
    }

    public static int[] job(int[] d){
        int[] tempD = new int[d.length+1];
        tempD[0] = 0;
        for(int i=0;i<d.length;i++){
            tempD[i+1] = d[i];
        }
        int[] j = new int[d.length];
        j[0] = 0;
        j[1] = 1;
        for(int i=2;i<tempD.length;i++){
            int r = i;
            while(tempD[i]<tempD[j[r-1]]&&tempD[j[r-1]]>r-1)
                r = r-1;
            if(tempD[j[r-1]]<=tempD[i]&&tempD[i]>=r){
                for(int k=i-1;k>=r;k--)
                    j[k+1] = j[k];
                j[r] = i;
            }
        }
        return j;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] strings1 = scanner.nextLine().split(" ");
        String[] strings2 = scanner.nextLine().split(" ");
        int[] p = new int[strings1.length];
        int[] d = new int[strings2.length];
        for(int i=0;i<strings1.length;i++){
            p[i] = Integer.parseInt(strings1[i]);
            d[i] = Integer.parseInt(strings2[i]);
        }
        bubbleSort(p,d);
        for (int i=0;i<p.length;i++){
            System.out.println(p[i]+":"+d[i]);
        }
        int[] j = job(d);

        System.out.print("作业顺序：");
        for(int i=0;i<j.length;i++){
            if(j[i]-1>=0){
                System.out.print(p[j[i]-1]+"("+d[j[i]-1]+") ");
            }
        }
    }
}

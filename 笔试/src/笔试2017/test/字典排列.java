package 笔试2017.test;

import java.util.Scanner;

public class 字典排列 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] num = new int[n];
        for(int i=0;i<n;i++){
            num[i] = sc.nextInt();
        }
        sc.close();
        for(int i=0;i<n;i++){
            int temp = num[i];
            if(temp!=i+1){
                int k=i+1;
                for(int j=i+1;j<n;j++){
                    if (num[j]<num[k]){
                        k = j;
                    }
                }
                num[i] = num[k];
                num[k] = temp;
                break;
            }
        }
        for(int i=0;i<n;i++){
            System.out.print(num[i]+" ");
        }
    }
}


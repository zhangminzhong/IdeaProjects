package 笔试2017.test;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class 搜狐 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] a = new int[m];
        for(int i=0;i<m;i++){
            a[i] = scanner.nextInt();
        }
        if(a.length==1) {
            for (int i = 0; i < n; i++)
                System.out.println(a[0]);
            System.exit(0);
        }
        List<Integer> list = new LinkedList<Integer>();
        if(a[0]==1) {
            list.add(a[0]);
            for (int i = 1; i < n &&list.size()<n;i++){
                if(i==1)
                    for(int j=1;j<=a[1];j++){
                        if(list.size()<n)
                            list.add(a[1]);
                        else
                            break;
                    }
                else{
                    int count = list.get(i);
                    for(int j=1;j<=count;j++){
                        if(list.size() < n)
                            list.add(a[i%a.length]);
                    }
                }
            }
        }
        else {
            for(int i=0;i<n&&list.size()<=n;i++){
                if(i==0)
                    for(int j=1;j<=a[0];j++) {
                        if (list.size() < n)
                            list.add(a[0]);
                    }
                else{
                    int count = list.get(i);
                    for(int j=1;j<=count;j++){
                        if(list.size() < n)
                            list.add(a[i%a.length]);
                    }
                }
            }
        }

        for(int i=0;i<list.size();i++)
            System.out.println(list.get(i));
    }
}
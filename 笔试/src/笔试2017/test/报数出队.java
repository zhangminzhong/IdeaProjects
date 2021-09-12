package 笔试2017.test;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by zhang_minzhong on 2017/9/2.
 */
public class 报数出队 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        LinkedList<Integer> list = new LinkedList<Integer>();
        for(int i=1;i<=n;i++)
            list.add(i);
        int num = 1;
        int sum = 0;
        while(list.size()>0){
            if(num<m){
                num++;
                sum++;
            }
            else {
                int index = sum%list.size();
                int temp = list.remove(index);
                System.out.print(temp);
                if(list.size()>0){
                    num = 1;
                    sum = index;
                }
            }
        }
    }
}

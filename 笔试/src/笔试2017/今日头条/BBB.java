package 笔试2017.今日头条;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Created by zhang_minzhong on 2017/8/22.
 */
public class BBB {
    private static List<Integer> list = new ArrayList<Integer>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] num = new int[n];
        for(int i=0;i<n;i++){
            num[i] = scanner.nextInt();
        }
        calculate(num,0);
        Collections.sort(list);
        System.out.println(list.get(list.size()-1));
    }
    private static void calculate(int[] num, int index) {

        for(int i=index;i<num.length;i++){
            for(int j=index;j<num.length;j++){
                int min = min(num,index,j);
                int all = sum(num,index,j);
                list.add(min*all);
            }
        }
    }

    private static int sum(int[] num, int begin, int end) {
        int result = 0;
        for(int i=begin;i<=end;i++){
            result += num[i];
        }
        return result;
    }

    private static int min(int[] num,int begin, int end) {
        int min = num[begin];
        while(begin<=end){
            if(num[begin]<min)
                min = num[begin];
            begin++;
        }
        return min;
    }
}

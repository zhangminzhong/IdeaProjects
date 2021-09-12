package 笔试2017.test.拼多多;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by zhang_minzhong on 2017/8/1.
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String nStr = scanner.nextLine();
        int n = Integer.parseInt(nStr);
        String line = scanner.nextLine();
        String[] nStrArr = line.split(" ");
        int[] A = new int[n];
        for(int i=0;i<n;i++){
            A[i] = Integer.parseInt(nStrArr[i]);
        }
        Arrays.sort(A);
        //判断是否有三个正数
        List<Integer> negativeList = new ArrayList<Integer>();
        boolean hasZero = false;
        List<Integer> positiveList = new ArrayList<Integer>();
        for(int i=0;i<A.length;i++){
            if(A[i]<0)
                negativeList.add(A[i]);
            else if(A[i]==0)
                hasZero = true;
            else
                positiveList.add(A[i]);
        }
        int negSize = negativeList.size();
        int posSize = positiveList.size();
        if(posSize>=3){
            int result = positiveList.get(posSize-1)*positiveList.get(posSize-2)*positiveList.get(posSize-3);
            if(negSize>=2){
                int a = positiveList.get(posSize-1)*negativeList.get(0)*negativeList.get(1);
                if(result<a)
                    result = a;
            }
            System.out.println(result);
        }
        else if(posSize==2){
            if(hasZero)
                System.out.println(0);
            else if(negSize>=2)
                System.out.println(positiveList.get(1)*negativeList.get(0)*negativeList.get(1));
            else
                System.out.println(positiveList.get(0)*positiveList.get(1)*negativeList.get(0));
        }
        else if (posSize==1){
            if(negSize>=2)
                System.out.println(positiveList.get(0)*negativeList.get(0)*negativeList.get(1));
            else
                System.out.println(0);
        }
        else{
            if (hasZero)
                System.out.println(0);
            else System.out.println(negativeList.get(negSize-1)*negativeList.get(negSize-2)*negativeList.get(negSize-3));
        }
    }
}

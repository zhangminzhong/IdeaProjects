package 笔试2017.招行信用卡;

import java.util.Scanner;

/**
 * Created by zhang_minzhong on 2017/9/21.
 */
public class 同事上班员工数 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int[] begin = new int[n];
        int[] end = new int[n];
        for(int i=0;i<n;i++){
            String[] arr = sc.nextLine().split(" ");
            begin[i] = Integer.parseInt(arr[0]);
            end[i] = Integer.parseInt(arr[1]);
        }
        int max = 0;
        for(int i=0;i<n;i++){
            int count = 1;
            int tempB = begin[i];
            int tempE = end[i];
            for(int j=i+1;j<n;j++){
                if(tempB>end[j]||tempE<begin[j])
                    continue;
                else {
                    if(tempB<=begin[j])
                        tempB = begin[j];
                    if(tempE>=end[j])
                        tempE = end[j];
                    System.out.println(tempB+":"+tempE);
                    count++;
                }
            }
            if(max<count){
                max = count;
            }
        }
        System.out.println(max);
    }
}

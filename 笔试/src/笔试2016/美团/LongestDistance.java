package 笔试2016.美团;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by zhang_minzhong on 2017/3/13.
 */
public class LongestDistance {

    public static void main(String[] args) {
        int[] A = {1,2,3,4,5,6,7,8,9,0};
        int result = new LongestDistance().getDis(A,A.length);
        System.out.println(result);
    }

    public int getDis(int[] A, int n) {
        List<Integer> integerList = new ArrayList<Integer>();
        int temp = 0;
        for(int i=0;i<A.length;i++){
            for(int j=i;j<A.length;j++){
                temp = A[j] - A[i];
                integerList.add(temp);
            }
        }
        Collections.sort(integerList);
        int max = integerList.get(integerList.size()-1);
        if(max<0)
            return 0;
        else
            return max;
    }
}

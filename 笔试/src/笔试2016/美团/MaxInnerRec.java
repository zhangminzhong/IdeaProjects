package 笔试2016.美团;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by zhang_minzhong on 2017/3/13.
 */
public class MaxInnerRec {
    public int countArea(int[] A, int n) {
        List<Integer> areaList = new ArrayList<Integer>();
        for(int i=0;i<n;i++){
            int width=1;
            int leftIndex = i-1;
            int rightIndex = i+1;
            while (leftIndex>=0&&A[leftIndex]>=A[i]){
                width++;
                leftIndex--;
            }
            while (rightIndex<n&&A[rightIndex]>=A[i]){
                width++;
                rightIndex++;
            }
            int area = A[i]*width;
            areaList.add(area);
        }
        Collections.sort(areaList);
        return areaList.get(areaList.size()-1);
    }
}

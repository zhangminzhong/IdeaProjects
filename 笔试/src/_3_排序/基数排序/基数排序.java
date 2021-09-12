package _3_排序.基数排序;

import _3_排序.paixu.Util;

import java.util.ArrayList;
import java.util.List;


public class 基数排序 {

    public static void main(String[] args) {
        int[] arr = Util.getArr();
        radixSort(arr);
        Util.print(arr);
    }

    private static void radixSort(int[] a) {
        // 找到最大数，确定要排几趟
        int max = 0;
        for (int i = 0; i < a.length; i++)
            if (max < a[i])
                max = a[i];
        int times = 0;
        while(max>0){
            times++;
            max/=10;
        }
        //建立10个list
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        for(int i=0;i<10;i++){
            List<Integer> list1 = new ArrayList<Integer>();
            list.add(list1);
        }
        //进行times次分配和收集
        for(int i=0;i<times;i++){
            //分配
            for(int j=0;j<a.length;j++){
                int x = a[j]%(int)Math.pow(10, i+1)/(int)Math.pow(10, i);
                list.get(x).add(a[j]);
                //list.set(x, element)
            }
            //收集
            int count = 0;
            for(int j=0;j<10;j++){
                while(list.get(j).size()>0){
                    a[count] = list.get(j).get(0);
                    list.get(j).remove(0);
                    count++;
                }
            }
        }


    }

}

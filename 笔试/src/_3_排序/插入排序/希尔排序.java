package _3_排序.插入排序;

import _3_排序.paixu.Util;

public class 希尔排序 {

    public static void main(String[] args) {
        int arr[]= Util.getArr();
        shellSort(arr);
        Util.print(arr);
    }

    public static int[] shellSort(int[] a){
        int j;
        for(int increment=a.length/2;increment>0;increment/=2){
            for(int i=increment;i<a.length;i++){
                int temp = a[i];
                for(j=i;j>=increment&&temp<a[j-increment];j-=increment)
                    a[j] = a[j-increment];
                a[j] = temp;
            }
            Util.print(a);
        }
        return a;
    }

}

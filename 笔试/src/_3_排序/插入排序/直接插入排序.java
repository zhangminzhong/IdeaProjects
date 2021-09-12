package _3_排序.插入排序;


import _3_排序.paixu.Util;

public class 直接插入排序 {

    public static void main(String[] args) {
        int arr[]= Util.getArr();
        insertSort(arr);
        Util.print(arr);
    }

    public static int[] insertSort(int[] a){
        int j;
        for(int i=1;i<a.length;i++){
            int temp = a[i];
            for(j=i;j>0&&temp<a[j-1];j--)
                a[j] = a[j-1];
            a[j] = temp;
        }
        return a;
    }

}

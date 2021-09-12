package _3_排序.选择排序;


import _3_排序.paixu.Util;

public class 简单选择排序 {

    public static void main(String[] args) {
        int arr[]= Util.getArr();
        selectSort(arr);
        Util.print(arr);

    }
    public static void selectSort(int[] a){
        int min,temp;
        for(int i=0;i<a.length-1;i++){
            min = i;
            for(int j=i+1;j<a.length;j++)
                if(a[min]>a[j])
                    min = j;
            if(min!=i){
                temp = a[min];
                a[min] = a[i];
                a[i] = temp;
            }
        }
    }
}

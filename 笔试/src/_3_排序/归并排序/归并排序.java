package _3_排序.归并排序;


import _3_排序.paixu.Util;

public class 归并排序 {

    public static void main(String[] args) {
        int[] arr = Util.getArr();
        mergeSort(arr,0,arr.length-1);
        Util.print(arr);
    }

    public static void mergeSort(int[] a,int left,int right){
        if(left<right){
            int middle = (left+right)/2;
            System.out.println("left="+left+",right="+right);
            //对左边进行递归
            mergeSort(a,left,middle);
            System.out.println("开始右边，"+"left="+left+",right="+right);
            //对右边进行递归
            mergeSort(a,middle+1,right);
            System.out.println("开始合并，"+"left="+left+",right="+right);
            //合并
            merge(a,left,middle,right);
        }
    }

    public static void merge(int[] a, int left, int middle, int right) {
        int[] tempArr = new int[a.length];
        int tempLeft = left;
        int mid = middle+1;//右边起始位置
        int temp = left;
        //从两个数组中选择较小数放入中间数组
        while(left<=middle&&mid<=right)
            if(a[left]<=a[mid])
                tempArr[tempLeft++] = a[left++];
            else
                tempArr[tempLeft++] = a[mid++];
        //将剩余部分放入中间数组
        while(left<=middle)
            tempArr[tempLeft++] = a[left++];
        while(mid<=right)
            tempArr[tempLeft++] = a[mid++];
        //将中间数组复制回原数组
        while(temp<=right){
            a[temp] = tempArr[temp++];
        }
    }
}

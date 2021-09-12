package 笔试2017.test;


import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * Created by zhang_minzhong on 2017/8/9.
 */
public class 必须会写的几种排序算法 {
    ThreadLocal<DateFormat> threadLocal = new ThreadLocal<DateFormat>(){
        @Override
        protected DateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        }
    };
    public static void main(String[] args) {
        /*String str2 = new StringBuilder("计算机").append("软件").toString();
        System.out.println(str2.intern()==str2);*/
        int[] a = {8,5,3,4,7,9,1,0,2,6};
        mergeSort(a,0,a.length-1);
        for(int i=0;i<a.length;i++)
            System.out.print(a[i]+" ");
    }
    public static void bubbleSort(int[] a){
        for(int i=0;i<a.length-1;i++) {
            boolean exchane = false;
            for (int j = 0; j < a.length - 1 - i; j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                    exchane = true;
                }
            }
            if (!exchane) {
                return;
            }
        }
    }
    public static void selectSort(int[] a){
        int k,temp;
        for(int i=0;i<a.length-1;i++){
            k = i;
            for(int j=i+1;j<a.length;j++){
                if(a[k]>a[j]){
                    k = j;
                }
            }
            if(k!=i){
                temp = a[k];
                a[k] = a[i];
                a[i] = temp;
            }
        }
    }
    public static void insertSort(int[] a){
        for(int i=1;i<a.length;i++){
            int temp = a[i];
            int j;
            for (j=i;j>0;j--){
                if(temp<a[j-1])
                    a[j] = a[j-1];
                else
                    break;
            }
            a[j] = temp;
        }
    }
    public static void quickSort(int[] a,int low,int high){
        if(low<high){
            int middle = getMiddle(a,low,high);
            quickSort(a,low,middle-1);
            quickSort(a,middle+1,high);
        }
    }

    private static int getMiddle(int[] a, int low, int high) {
        int temp = a[low];
        while(low<high){
            while (low<high&&a[high]>=temp)
                high--;
            a[low] = a[high];
            while (low<high&&a[low]<=temp){
                low++;
            }
            a[high] = a[low];
            a[low] = temp;
        }
        return low;
    }
    public static void mergeSort(int[] a,int left,int right){
        if(left<right){
            int middle = (left+right)/2;
            mergeSort(a,left,middle);
            mergeSort(a,middle+1,right);
            merge(a,left,middle,right);
        }
    }

    public static void merge(int[] a, int left, int middle, int right) {
        int[] temp = new int[a.length];
        int tempLeft = left;
        int index = left;
        int mid = middle+1;
        while (left<=middle&&mid<=right){
            if(a[left]<=a[mid])
                temp[tempLeft++] = a[left++];
            else
                temp[tempLeft++] = a[mid++];
        }
        while (left<=middle)
            temp[tempLeft++] = a[left++];
        while (mid<=right)
            temp[tempLeft++] = a[mid++];
        while (index<=right){
            a[index]  = temp[index];
            index++;
        }
    }
}


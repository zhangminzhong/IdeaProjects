package _3_排序.交换排序;


import _3_排序.paixu.Util;

import java.util.Scanner;

public class 快速排序 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] arr = sc.nextLine().trim().split(",");
        int[] a = new int[arr.length];
        for(int i=0;i<a.length;i++){
            a[i] = Integer.parseInt(arr[i]);
        }
        quikSort(a,0,a.length-1);
        for(int i=0;i<a.length;i++){
            System.out.print(a[i]+" ");
        }
    }
	
	
	public static void quikSort(int[] a,int low,int high) {
		if(low<high) {
            int middle = getMiddle(a, low, high);
            quikSort(a, low, middle - 1);
            quikSort(a, middle + 1, high);
        }
	}
	
	public static int getMiddle(int[] a,int low,int high){
		int temp = a[low];
		while(low<high){
			while(low<high&&temp<=a[high])
				high--;
			a[low] = a[high];
			while(low<high&&temp>=a[low])
				low++;
			a[high] = a[low];
			a[low] = temp;
		}
        for(int i=0;i<a.length;i++)
            System.out.print(a[i]+" ");
        System.out.println();
		return low;
    }

}

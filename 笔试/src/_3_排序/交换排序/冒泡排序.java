package _3_排序.交换排序;

import _3_排序.paixu.Util;

public class 冒泡排序 {
	public static void main(String args[])
	{
		int arr[]= Util.getArr();
		bubbleSort(arr);
		Util.print(arr);
	}
	public static int[] bubbleSort(int[] a){
		boolean isWrap;
		for (int i=0;i<a.length-1;i++) {
            isWrap = false;
            for (int j = 0; j < a.length - 1 - i; j++)
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                    isWrap = true;
                }
            if (isWrap == false)
                return a;
        }
		return a;
	}
	
}

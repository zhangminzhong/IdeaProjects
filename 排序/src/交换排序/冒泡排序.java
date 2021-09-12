package 交换排序;

public class 冒泡排序 {
	public static void main(String args[])
	{
        int arr[]={8,6,12,5,14,7,21,2,9,3};
		bubbleSort(arr);
		for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
	public static int[] bubbleSort(int[] a){
		boolean didSwap;
		for (int i=1;i<a.length;i++) {
            didSwap = false;
            for (int j = 0; j < a.length - i; j++)
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                    didSwap = true;
                }
            if (didSwap==false)
                return a;
        }
		return a;
	}
	
}

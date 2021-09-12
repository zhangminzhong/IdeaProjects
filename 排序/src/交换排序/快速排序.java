package 交换排序;


public class 快速排序 {

	public static void main(String[] args) {
        int arr[]={8,6,12,5,14,7,21,2,9,3};
		quikSort(arr,0,arr.length-1);
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
	}
	
	
	public static void quikSort(int[] a,int low,int high) {
		for(int i=0;i<a.length;i++){
			System.out.print(a[i]+",");
		}
		System.out.println();
		if(low<high){
			int middle = getMiddle(a, low, high);
			quikSort(a, low, middle-1);
			quikSort(a, middle+1, high);
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
		return low;
	}

}

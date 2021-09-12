package 笔试2016.去哪儿;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	private static int count=0;
	public static void main(String[] args) {	
        Scanner scanner = new Scanner(System.in);
		String[] str = scanner.nextLine().split(" ");
		int[] priceArr;
        int a;
		priceArr = new int[str.length - 1];
		for (int i = 0; i < priceArr.length; i++) {
			priceArr[i] = Integer.parseInt(str[i]);
		}
		a = Integer.parseInt(str[str.length - 1]);
		Arrays.sort(priceArr);
		for(int i=priceArr.length-1;i>=0;i--){
			while(a>=priceArr[i]){
				count++;
				a-=priceArr[i];
			}
		}
		
		if(count==0)
	    	System.out.println(-1);
		else
			System.out.println(count);
	}
	/*public static int[] selectSort(int[] a){
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
		return a;
	}*/
	
}

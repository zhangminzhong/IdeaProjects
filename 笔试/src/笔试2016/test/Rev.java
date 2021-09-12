package 笔试2016.test;
import java.util.Scanner;


public class Rev {
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		String s = scanner.nextLine();
		String[] sArr = s.split(" ");
		int x = Integer.parseInt(sArr[0]);
		int y = Integer.parseInt(sArr[1]);
		System.out.println(rev(rev(x)+rev(y)));
	}
	//��һ�������ķ�ת����
	public static int rev(int num){
		int[] a = new int[100];
		int j=0,result=0,temp=1;
		int m=num;
		for(int i=1;i<=m;i=i*10){
			a[j] = num%10;
			j++;
			num=num/10;
		}
		for(int i=j-1;i>=0;i--){
			result = result+a[i]*temp;
			temp=temp * 10;
		}
		return result;
	}
}

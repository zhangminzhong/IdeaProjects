package 笔试2016.滴滴;
import java.util.Scanner;

public class XiuGai {

	public static void main(String[] args) {
		int n,result;
		Scanner scanner = new Scanner(System.in);
		n = scanner.nextInt();
		result = fun1(n);
		System.out.println(result);
	}
	public static int fun1(int n){
		int num=0;
		int i,j;
		for(i=5;i<=n;i+=5){
			j=i;
			while(j%5 == 0){
				num++;
				j/=5;
			}
		}
		return num;
	}
}

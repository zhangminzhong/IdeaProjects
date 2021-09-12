package 笔试2016.去哪儿;

import java.util.Scanner;

public class N次方 {

	public static void main(String[] args) {
		int n;
		Scanner scanner = new Scanner(System.in);
		n = scanner.nextInt();
		boolean flag = isPowerOfTwo(n);
		if (flag)
		{
			System.out.println("true");
		}
		else
		{
			System.out.println("false");
		}
	}
	public static boolean isPowerOfTwo(int n)
	{
		if ((n&(n-1))==0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

}
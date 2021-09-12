package 笔试2016.完美世界;


import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		int m,n;
		Scanner scanner = new Scanner(System.in);
		m=scanner.nextInt();
		n=scanner.nextInt();
		int count = 0;
		for (int i = m; i <= n-2 ; i ++)
		{
			if (isPrime(i) && isPrime(i + 2))
			{
				System.out.println(i+" "+(i+2)+" ");
				count++;
			}
		}
		if (count == 0)
		{
			System.out.println("no");
		}
		else
		{
			System.out.println();
		}
	}
	static boolean  isPrime(int num){
		int tmp = (int) Math.sqrt(num);
		for (int i = 2; i <= tmp; i++)
			if (num %i == 0)
				return false;
		return true;
	}

}
/*
 * #include <iostream>
#include <cmath>
using namespace std;
bool isPrime(int num)
{
	int tmp = sqrt(num);
	for (int i = 2; i <= tmp; i++)
		if (num %i == 0)
			return 0;
	return 1;
}
int main()
{
	int m, n;
	cin >> m >> n;
	int count = 0;
	for (int i = m; i <= n-2 ; i ++)
	{
		if (isPrime(i) && isPrime(i + 2))
		{
			cout << i << " " << i + 2 << " ";
			count++;
		}
	}
	if (count == 0)
	{
		cout << "no" << endl;
	}
	else
	{
		cout << endl;
	}
	return 0;
}

 */
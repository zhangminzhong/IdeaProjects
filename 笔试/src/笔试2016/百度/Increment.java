package 笔试2016.百度;

import java.util.Scanner;

public class Increment {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.print("initialValue = ");
		int initialValue = scanner.nextInt();
		System.out.println();
		System.out.print("rows = ");
		int rows = scanner.nextInt();
		System.out.println();
		System.out.print("columns = ");
		int columns = scanner.nextInt();
		System.out.println();
		int[][] a = new int[rows][columns];
		for (int i = 0; i < rows; i++)
			for (int j = 0; j < columns; j++) {
				if (i == 0 && j == 0)
					a[0][0] = initialValue;
				else if (j == 0)
					a[i][0] = a[i - 1][columns - 1] + 1;
				else
					a[i][j] = a[i][j - 1] + 1;
			}

		int[][] t = new int[columns][rows];
		for (int i = 0; i < columns; i++)
			for (int j = 0; j < rows; j++) {
				t[i][j] = a[j][i];
			}
		
		/*for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++)
				System.out.print(a[i][j] + " ");
			System.out.println();
		}
		System.out.println();
		for (int i = 0; i < columns; i++) {
			for (int j = 0; j < rows; j++)
				System.out.print(t[i][j] + " ");
			System.out.println();
		}
		System.out.println();*/
		
		int[][] mul = new int[rows][rows];
		for (int i = 0; i < a.length; i++)
			for (int j = 0; j < t[0].length; j++) {
				int sum = 0;
				for (int k = 0; k < t.length; k++)
					sum += a[i][k] * t[k][j];
				mul[i][j] = sum;
			}

		
		
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < rows; j++)
				System.out.print(mul[i][j] + " ");
			System.out.println();
		}

	}

}

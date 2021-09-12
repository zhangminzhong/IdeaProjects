package 笔试2016.test;
import java.util.Scanner;

public class Reversal {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String s = scanner.nextLine();
		String[] sArr = s.split(" ");
		int x = Integer.parseInt(sArr[0]);
		int y = Integer.parseInt(sArr[1]);
		System.out.println(rev(rev(x) + rev(y)));
	}

	public static int rev(int x) {
		String temp = "";
		while (x != 0) {
			temp += String.valueOf(x % 10);
			x /= 10;
		}
		int k = 0;
		char[] tempArray = temp.toCharArray();
		for (int j = 0; j < temp.length(); j++) {
			if (tempArray[j] == '0')
				k = k + 1;
			else
				break;

		}
		return Integer.parseInt(temp.substring(k));
	}

}

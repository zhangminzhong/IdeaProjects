package 笔试2016.小米;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class 句子反转 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		List<String> list = new LinkedList<String>();
		while(scanner.hasNextLine()){
			String[] strArr = scanner.nextLine().split(" ");
			for(int i=0;i<strArr.length;i++)
				list.add(strArr[i]);
			for(int i=list.size()-1;i>=0;i--)
					System.out.print(list.get(i)+" ");
			System.out.println();
		}
	}

}

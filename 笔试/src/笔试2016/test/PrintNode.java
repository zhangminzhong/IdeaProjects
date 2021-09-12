package 笔试2016.test;
import java.util.*;

public class PrintNode {
	private static Scanner scanner;
	private static List<List<Integer>> headList = new ArrayList<List<Integer>>();

	public static void main(String[] args) {

		scanner = new Scanner(System.in);

		for (int i = 0; i < 5; i++) {
			List<Integer> list = new ArrayList<Integer>();
			while (scanner.hasNextInt())
				list.add(scanner.nextInt());
			scanner = new Scanner(System.in);
			headList.add(list);
			System.out.println(i);
		}
/*1 2 3 4 5
4 6 7
7 8 9 10
5 11 12
12 13
 */
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(headList.get(0).get(0));
		while (queue.size() > 0) {
			int u = queue.poll();
			System.out.print(u + " ");
			List<Integer> uList = getList(headList, u);
			if (uList != null) {
				for (int i = 1; i < uList.size(); i++) {
					queue.offer(uList.get(i));
				}
			}
		}

	}

	// ���ظ��ڵ�Ϊinteger��list
	public static List<Integer> getList(List<List<Integer>> headList,
			Integer integer) {
		int temp1 = integer;
		for (int i = 0; i < headList.size(); i++) {
			int temp2 = headList.get(i).get(0);
			if (temp1 == temp2)
				return headList.get(i);

		}
		return null;
	}
}

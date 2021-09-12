package 笔试2016.百度;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class BstMinSum {

	private static List<Integer> sums = new ArrayList<Integer>();
	private static LinkedList<Integer> stack = new LinkedList<Integer>();
	private static int pathId = 0;

	public static void main(String[] args) {
		
		TNode h = new TNode(8, null, null);
		TNode g = new TNode(10, null, null);
		TNode f = new TNode(3, null, null);
		TNode e = new TNode(5, g, h);
		TNode d = new TNode(7, f, null);
		TNode c = new TNode(4, null, null);
		TNode b = new TNode(2, e, null);
		TNode a = new TNode(9, c, d);
		TNode t = new TNode(1, a, b);

		System.out.println("·������СֵΪ��" + minTreePath(t));
	}

	public static int minTreePath(TNode t) {
		getPath(t);
		return getMinPathSum();
	}

	public static void getPath(TNode t) {
		if(t==null)
			return;
		stack.push(t.value);
		if (t.left == null && t.right == null) {
			pathId++;
			System.out.print("��" + pathId + "��·����");
			for (int i = stack.size() - 1; i >= 0; i--)
				System.out.print(stack.get(i) + " ");
			getSum();
			System.out.println();
		}
		getPath(t.left);
		getPath(t.right);
		stack.pop();
			
	}

	public static void getSum() {
		int sum = 0;
		for (int i = 0; i < stack.size(); i++)
			sum += stack.get(i);
		sums.add(sum);
		System.out.print("�ܳ��ȣ�"+sum);
	}

	public static int getMinPathSum() {
		int[] sumArray = new int[sums.size()];
		for (int i = 0; i < sumArray.length; i++)
			sumArray[i] = sums.get(i);
		Arrays.sort(sumArray);
		return sumArray[0];
	}
}

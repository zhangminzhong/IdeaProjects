package 笔试2016.小米;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class 树的高度 {

	private static int[][] matrix;
	private static LinkedList<Integer> stack = new LinkedList<Integer>();
	private static List<Integer> deepList = new ArrayList<Integer>();

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		int n = Integer.parseInt(scanner.nextLine());
		matrix = new int[n-1][2];
		for (int i = 0; i < n - 1; i++) {
			String str = scanner.nextLine();
			String[] strArr = str.trim().split(" ");
			matrix[i][0] = Integer.parseInt(strArr[0]);
			matrix[i][1] = Integer.parseInt(strArr[1]);
		}
		TNode t = new TNode(0, null, null);
		createTree(t);
		getPath(t);
		int deep = getMaxDeep();
		System.out.println(deep);
		/*
		 * TNode h = new TNode(1, null, null); TNode g = new TNode(9, null,
		 * null); TNode f = new TNode(4, h, null); TNode e = new TNode(5, null,
		 * g); TNode d = new TNode(6, null, null); TNode c = new TNode(7, null,
		 * null); TNode b = new TNode(2, e, f); TNode a = new TNode(3, c, d);
		 * TNode t = new TNode(1, a, b); getPath(t);
		 */
	}

	private static int getMaxDeep() {
		int maxDeep = 0;
		for (int i = 0; i < deepList.size(); i++)
			if (maxDeep < deepList.get(i))
				maxDeep = deepList.get(i);
		return maxDeep;
	}

	public static void getPath(TNode t) {
		if(t==null)
			return;
		stack.push(t.value);
		if (t.left == null && t.right == null) {
			/*for (int i = stack.size() - 1; i >= 0; i--)
				System.out.print(stack.get(i) + " ");
			System.out.println();*/
			deepList.add(stack.size());

		}
		getPath(t.left);
		getPath(t.right);
		stack.pop();
	}

	private static void createTree(TNode t) {
		int value = t.value;
		for (int i = 0; i < matrix.length; i++) {
			if (matrix[i][0] == value && t.left == null) {
				TNode leftChild = new TNode(matrix[i][1], null, null);
				t.left = leftChild;
				createTree(leftChild);
			}
			if (matrix[i][0] == value && t.right == null) {
				TNode rightChild = new TNode(matrix[i][1], null, null);
				t.right = rightChild;
				createTree(rightChild);
			}
		}
	}

}

class TNode {
	public int value;
	public TNode left;
	public TNode right;

	public TNode(int value, TNode left, TNode right) {
		this.value = value;
		this.left = left;
		this.right = right;
	}
}
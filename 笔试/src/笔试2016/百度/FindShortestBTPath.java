package 笔试2016.百度;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindShortestBTPath {

    // ������¼���е�·��
    private static List<ArrayList<Integer>> allPaths = new ArrayList<ArrayList<Integer>>();
    // ������¼һ��·��
    private static List<Integer> onePath = new ArrayList<Integer>();
    
    // �������е�·��
    public static void FindAllPath(TNode root) {
        if(root == null)
            return;
        
        // �ѵ�ǰ�����뵽·��������
        onePath.add(root.value);
        
        // ���ΪҶ�ӽ�㣬���onePath���뵽allPaths����
        if(root.left == null && root.right == null){
            allPaths.add(new ArrayList<Integer>(onePath));
        }
        
        FindAllPath(root.left);
        FindAllPath(root.right);
        
        // ����ط�����ͨ�����ݹ�������⣬����Ҷ�ӽ�������㻹���ҽ�㣬���ᾭ��������һ��������������Ҫ
        onePath.remove(onePath.size() - 1);
        //return allPaths;
    }
    
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
		FindAllPath(t);
		int shortestPath = findShortestPath();
		System.out.println(shortestPath);
    }

	private static int findShortestPath() {
		int[] totalArr = new int[allPaths.size()];
		for(int i=0;i<totalArr.length;i++){
			List<Integer> path = allPaths.get(i);
			int temp = 0;
			for(int j=0;j<path.size();j++){
				temp+=path.get(j);
		    	System.out.print(path.get(j)+" ");
			}
        	System.out.println();
			totalArr[i] = temp;
		}
		Arrays.sort(totalArr);
		return totalArr[0];
	}

}
package 笔试2017.test;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by zhang_minzhong on 2017/9/13.
 */
public class 推荐人 {
    static class Node{
        public Node left;
        public Node right;
        public int value;
        public int leftValue;
        public int rightValue;

        public Node(int leftValue, int rightValue, int value) {
            this.leftValue = leftValue;
            this.rightValue = rightValue;
            this.value = value;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] strings = sc.nextLine().split(" ");
        int m = Integer.parseInt(strings[0]);
        int n = Integer.parseInt(strings[1]);
        List<Node> list = new LinkedList<Node>();
        for(int i=0;i<m;i++){
            String[] temp = sc.nextLine().split(" ");
            //list.add(new Node(()));
        }
    }

    public int countNum(Node root){
        if(root==null){
            return 0;
        }

        if(root.right==null&&root.left!=null){
            return countNum(root.left)+1;
        }
        else if(root.right!=null&&root.left==null){
            return countNum(root.right)+1;
        }
        else{
            return countNum(root.left)+countNum(root.right)+2;
        }
    }
}

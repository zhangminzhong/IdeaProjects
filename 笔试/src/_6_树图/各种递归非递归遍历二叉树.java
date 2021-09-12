package _6_树图;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class 各种递归非递归遍历二叉树 {
    private static Stack<TreeNode> stack = new Stack<TreeNode>();
    private static List<TreeNode> list = new ArrayList<TreeNode>();
    //先序遍历递归
    public static void perOrder(TreeNode p){
        if(p!=null) {
            list.add(p);
            perOrder(p.left);
            perOrder(p.right);
        }
    }
    //先序遍历非递归
    public static void perOrderNonRecursive(TreeNode p){
        if(p!=null){
            stack.push(p);
            while(!stack.isEmpty()){
                p = stack.pop();
                list.add(p);
                if(p.right!=null)
                    stack.push(p.right);
                if(p.left!=null)
                    stack.push(p.left);
            }
        }
    }
    //中序遍历递归
    public static void inOrder(TreeNode p){
        if(p!=null){
            inOrder(p.left);
            list.add(p);
            inOrder(p.right);
        }
    }
    //中序遍历非递归
    public static void inOrderNoRecursive(TreeNode p){
        while(p!=null||!stack.isEmpty()){
            while(p!=null){
                stack.push(p);
                p = p.left;
            }
            p = stack.pop();
            list.add(p);
            p = p.right;
        }
    }
    //后序遍历递归
    public static void postOrder(TreeNode p){
        if(p!=null){
            postOrder(p.left);
            postOrder(p.right);
            list.add(p);
        }
    }
    //后序遍历非递归
    public static void postOrderNoRecursive(TreeNode p){
        TreeNode q = p;
        while (p!=null){
            while(p.left!=null){//左子树入栈
                stack.push(p);
                p = p.left;
            }
            while(p!=null&&(p.right==null||p.right==q)){//当前无右子或右子已输出
                list.add(p);
                q = p;//记录上一个已输出节点
                if(stack.isEmpty())
                    return;
                p = stack.pop();
            }
            stack.push(p);//处理右子
            p = p.right;
        }
    }

    public static void main(String[] args) {
        TreeNode root = makeTreeNode();
        //perOrder(root);
        //perOrderNonRecursive(root);
        //inOrder(root);
        inOrderNoRecursive(root);
        //postOrder(root);
        //postOrderNoRecursive(root);
        print();
    }

    public static TreeNode makeTreeNode(){
        TreeNode node = new TreeNode(4);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(6);
        TreeNode node3 = new TreeNode(1);
        TreeNode node4 = new TreeNode(3);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(7);
        node.left = node1;
        node.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = node5;
        node2.right = node6;
        return node;
    }

    public static void print(){
        Iterator<TreeNode> iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.print(iterator.next().val + " ");
        }
        System.out.println();
    }
}

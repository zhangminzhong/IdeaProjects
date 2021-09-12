package _6_树图;

/**
 * Created by zhang_minzhong on 2017/9/7.
 */
public class 判断是否是平衡二叉树 {
    boolean isbalanced = true;
    public boolean IsBalanced_Solution(TreeNode root) {
        getDepth(root);
        return isbalanced;
    }
    public int getDepth(TreeNode root){
        if(root==null){
            return 0;
        }
        int left = getDepth(root.left);
        int right = getDepth(root.right);
        if(Math.abs(left-right)>1){
            isbalanced = false;
        }
        return left>right?left+1:right+1;
    }
}

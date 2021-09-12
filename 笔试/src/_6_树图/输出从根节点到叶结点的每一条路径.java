package _6_树图;

import java.util.List;
import java.util.Stack;

/**
 * Created by zhang_minzhong on 2017/9/7.
 */
public class 输出从根节点到叶结点的每一条路径 {
    public void countDepth(TreeNode p,Stack<TreeNode> stack,List<Integer> list){
        if(p!=null){
            stack.push(p);
            if(p.left==null&&p.right==null){
                list.add(stack.size());
                for(int i=0;i<stack.size();i++){
                    System.out.print(stack.get(i).val);
                }
                System.out.println();
            }
            else {
                countDepth(p.left,stack,list);
                countDepth(p.right,stack,list);
            }
            stack.pop();
        }
    }
}

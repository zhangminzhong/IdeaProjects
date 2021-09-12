package 笔试2017.test;



/**
 * Created by zhang_minzhong on 2017/8/25.
 */
import java.util.*;
public class 腾讯模拟_满二叉排序树中找三个点的根节点 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();
        int node1 = scanner.nextInt();
        int node2 = scanner.nextInt();
        int node3 = scanner.nextInt();
        int root = (int)Math.pow(2,k)/2;
        int leftNode = 1;
        int rightNode = (int)Math.pow(2,k)-1;
        for(int i=1;i<=k;i++){
            if(node1<root&&node2<root&&node3<root){
                rightNode = root-1;
                root = (leftNode + rightNode)/2;
            }
            else if(node1>root&&node2>root&&node3>root){
                leftNode = root+1;
                root = (leftNode + rightNode)/2;
            }
            else{
                System.out.println(root);
                break;
            }
        }
    }
}

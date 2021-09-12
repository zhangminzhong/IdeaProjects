package _1_剑指offer;

import java.math.BigDecimal;
import java.util.*;

/**
 * Created by zhang_minzhong on 2017/3/20.
 */
public class 牛客_剑指offer {

    //大数阶乘
    public static BigDecimal factorial(BigDecimal n){
        BigDecimal bd1 = new BigDecimal(1);//BigDecimal类型的1
        BigDecimal bd2 = new BigDecimal(2);//BigDecimal类型的2
        BigDecimal result = bd1;//结果集，初值取1
        while(n.compareTo(bd1) > 0){//参数大于1，进入循环
            result = result.multiply(n.multiply(n.subtract(bd1)));//实现result*（n*（n-1））
            n = n.subtract(bd2);//n-2后继续
        }
        return result;
    }

    //大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项。n<=39
    public int Fibonacci(int n) {
        int first = 1;
        int second = 1;
        if(n==0||n==1)
            return 1;
        else
            for(int i=2;i<=n;i++){
                int temp = first;
                first = second;
                second = temp+first;
            }
        return second;
    }

    //输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
    /*public int NumberOf1(int n) {
        int count = 0;
        while(n!=0){
            count++;
            n=n&(n-1);
        }
        return count;
    }*/
    public int NumberOf1(int n) {
        if(n>=0){
            String s = Integer.toString(n,2);
            int count = 0;
            for(int i=0;i<s.length();i++)
                if(s.charAt(i)=='1')
                    count++;
            return count;
        }
        else{
            String s = Integer.toString(-n,2);
            //不看符号位
            while(s.length()!=31)
                s = "0"+s;
            System.out.println(" "+s);
            //按位取反
            StringBuilder sb = new StringBuilder(s);
            for(int i=0;i<sb.length();i++){
                if(sb.charAt(i)=='0')
                    sb.replace(i,i+1,"1");
                else
                    sb.replace(i,i+1,"0");
            }
            System.out.println(" "+sb);
            //加上符号位
            sb.insert(0,"1");
            System.out.println(sb);
            //末尾加1
            for(int i=sb.length()-1;i>=0;i--){
                if(sb.charAt(i)=='0') {
                    sb.replace(i, i + 1, "1");
                    break;
                }
                else{
                    sb.replace(i, i + 1, "0");
                }
            }
            System.out.println(sb);
            int count = 0;
            for(int i=0;i<sb.length();i++)
                if(sb.charAt(i)=='1')
                    count++;
            return count;
        }
    }

    //用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
    public class TwoStackMakeQueue{
        Stack<Integer> stack1 = new Stack<Integer>();
        Stack<Integer> stack2 = new Stack<Integer>();
        public void push(int node) {
            stack1.push(node);
        }
        public int pop() {
            int node = stack1.remove(stack1.size()-1);
            for(int i=0;i<stack1.size();i++)
                stack2.push(stack1.get(i));
            return stack2.pop();
        }
    }

    //栈的压入、弹出序列
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        Stack<Integer> stack = new Stack<Integer>();
        int k=0;
        for(int i=0;i<pushA.length;i++){
            stack.push(pushA[i]);
            while (!stack.empty()&&stack.peek()==popA[k]){
                stack.pop();
                k++;
            }
        }
        return stack.empty();
    }

    //输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，所有的偶数位于位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
    public void reOrderArray(int [] array) {
        Queue<Integer> queue1 = new LinkedList<Integer>();
        Queue<Integer> queue2 = new LinkedList<Integer>();
        for(int i=0;i<array.length;i++){
            if(array[i]%2!=0)
                queue1.offer(array[i]);
            else
                queue2.offer(array[i]);
        }
        int index = 0;
        Iterator<Integer> iterator = queue1.iterator();
        while(iterator.hasNext()) {
            array[index] = queue1.poll();
            index++;
        }
        iterator = queue2.iterator();
        while(iterator.hasNext()) {
            array[index] = queue2.poll();
            index++;
        }
    }

    //顺时针打印矩阵
    public ArrayList<Integer> printMatrix(int[][] matrix) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        if (matrix == null) {
            return list;
        }
        int startX = 0;
        int startY = 0;
        int endY = matrix[0].length - 1;
        int endX = matrix.length - 1;
        while ((startX <= endX) && (startY <= endY)) {
            printCircle(list,matrix, startX, startY, endX, endY);
            startX++;
            startY++;
            endX--;
            endY--;
        }
        return list;
    }
    public void printCircle(ArrayList<Integer> list,int[][] matrix, int startX, int startY, int endX, int endY) {
        // only one column left
        if (startY == endY) {
            for (int i = startX; i <= endX; i++ )
                list.add(matrix[i][endY]);
            return;
        }
        // only one row left
        if (startX == endX) {
            for (int i = startY; i <= endY; i++ )
                list.add(matrix[startX][i]);
            return;
        }
        for (int i = startY; i < endY; i++ ) {
            list.add(matrix[startX][i]);
        }
        for (int i = startX; i < endX; i++ ) {
            list.add(matrix[i][endY]);
        }
        for (int i = endY; i > startY; i-- ) {
            list.add(matrix[endX][i]);
        }
        for (int i = endX; i > startX; i-- ) {
            list.add(matrix[i][startY]);
        }

    }

    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    //合并两个升序链表
    public ListNode Merge(ListNode list1,ListNode list2) {
        ListNode head1 = list1;
        ListNode head2 = list2;
        ListNode p1 = list1;
        if(list1==null&&list2==null)
            return null;
        if(list1!=null&&list2==null)
            return list1;
        if(list1==null&&list2!=null)
            return list2;
        while (list2!=null){
            int number = list2.val;
            list1 = head1;
            while (list1!=null) {
                if (list1.val < number) {
                    p1 = list1;
                    list1 = list1.next;
                }
                else
                    break;
            }
            if(list1==head1){
                head2 = list2.next;
                head1 = list2;
                list2.next = list1;
                list2 = head2;
            }
            else {
                head2 = list2.next;
                p1.next = list2;
                list2.next = list1;
                list2 = head2;
            }
        }
        return head1;
    }

    //反转链表
    public ListNode ReverseList(ListNode head) {
        ListNode temp1 = head;
        ListNode temp2 = head;
        ListNode temp3 = head;
        int count=0;
        while(temp1!=null){
            count++;
            temp1 = temp1.next;
        }
        int[] array = new int[count];
        for(int i=0;i<array.length;i++){
            array[i] = temp2.val;
            temp2 = temp2.next;
        }
        for(int i=0,j=array.length-1;i<=j;i++,j--){
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
        for(int i=0;i<array.length;i++) {
            temp3.val = array[i];
            temp3 = temp3.next;
        }
        return head;
    }

    //输入一个链表，输出该链表中倒数第k个结点
    public ListNode FindKthToTail(ListNode head,int k) {
        ListNode root = head;
        int count = 0;
        while(head!=null){
            count++;
            head = head.next;
        }
        if(k>count||k<=0)
            return null;
        else{
            ListNode listNode = null;
            for(int i=1;i<=count-k+1;i++){
                if(i==count-k+1)
                    listNode = root;
                else
                    root = root.next;
            }
            return listNode;
        }
    }

    //输入一个链表，从尾到头打印链表每个节点的值。
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> resultList = new ArrayList<Integer>();
        ArrayList<Integer> tempList = new ArrayList<Integer>();
        while(listNode.next!=null){
            tempList.add(listNode.val);
            listNode = listNode.next;
        }
        for(int i=tempList.size()-1;i>=0;i--){
            resultList.add(tempList.get(i));
        }
        return resultList;
    }

    //输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
    public class Solution {
        public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
            TreeNode head = buildTreePreOrderInOrder(pre,0,pre.length-1,in,0,in.length-1);
            return head;
        }
        public TreeNode buildTreePreOrderInOrder(int[] preOrder,int begin1,int end1,int[] inOrder,int begin2,int end2){
            if(begin1>end1||begin2>end2){
                return null;
            }
            int rootData=preOrder[begin1];
            TreeNode head=new TreeNode(rootData);
            int divider=findIndexInArray(inOrder,rootData,begin2,end2);
            int offSet=divider-begin2-1;
            TreeNode left=buildTreePreOrderInOrder(preOrder,begin1+1,begin1+1+offSet,inOrder,begin2,begin2+offSet);
            TreeNode right=buildTreePreOrderInOrder(preOrder,begin1+offSet+2,end1,inOrder,divider+1,end2);
            head.left=left;
            head.right=right;
            return head;
        }
        public int findIndexInArray(int[] a,int x,int begin,int end){
            for(int i=begin;i<=end;i++){
                if(a[i]==x)return i;
            }
            return -1;
        }
    }

    //输入两棵二叉树A，笔试2017.test.B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if(root2==null||root1==null)
            return false;
        return isSame(root1,root2)||isSame(root1.left,root2)||isSame(root1.right,root2);
    }
    public boolean isSame(TreeNode node1,TreeNode node2){
        if(node2==null)
            return true;
        if(node1==null)
            return false;

        return node1.val==node2.val&&isSame(node1.left,node2.left)&&isSame(node1.right,node2.right);
    }

    //二叉树的镜像
    public void Mirror(TreeNode root) {
        if(root==null)
            return;
        if(root.left==null&&root.right==null)
            return;
        else {
            TreeNode node = root.left;
            root.left = root.right;
            root.right = node;
            Mirror(root.left);
            Mirror(root.right);
        }
    }

    //从上往下打印出二叉树的每个节点，同层节点从左至右打印。
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> resultList = new ArrayList<Integer>();
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        if(root!=null){
            queue.offer(root);
            while(!queue.isEmpty()){
                TreeNode element = queue.poll();
                resultList.add(element.val);
                if(element.left!=null)
                    queue.offer(element.left);
                if(element.right!=null)
                    queue.offer(element.right);
            }
        }
        return resultList;
    }

    //二叉搜索树的后序遍历序列
    public boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence==null||sequence.length==0)
            return false;
        if(sequence.length==1)
            return true;
        return isBST(sequence,0,sequence.length-1);
    }
    private boolean isBST(int[] sequence, int start, int end) {
        if(start>end)//遍历完数组的一部分，没报错，返回true
            return true;
        int i=end;
        while(i>start&&sequence[i-1]>sequence[end]){//i从最后往前倒，一直找到第一个比当前根节点小的数，从这个数开始将字符串分为前后两部分
            i--;
        }
        for(int j=0;j<i-1;j++){//前办部门如果有比根节点大的数，返回false
            if(sequence[j]>sequence[end])
                return false;
        }
        return isBST(sequence,start,i-1)&&isBST(sequence,i,end-1);//遍历数组的前半部分和后半部分
    }

    //二叉树中和为某一值的路径
    private ArrayList<ArrayList<Integer>> resultList = new ArrayList<ArrayList<Integer>>();
    private ArrayList<Integer> path = new ArrayList<Integer>();
    private int num = 0;
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        if (root == null)
            return resultList;
        boolean isLeaf = root.left == null && root.right == null;
        num += root.val;
        path.add(root.val);
        if (num == target && isLeaf) {
            ArrayList<Integer> result = new ArrayList<Integer>();
            for (int i = 0; i < path.size(); i++)
                result.add(path.get(i));
            resultList.add(result);
        }
        if (num < target && root.left != null)
            FindPath(root.left, target);
        if (num < target && root.right != null)
            FindPath(root.right, target);
        num -= root.val;
        path.remove(path.size() - 1);
        return resultList;
    }

    //复杂链表的复制
    public class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }
    public RandomListNode Clone(RandomListNode pHead) {
        HashMap<RandomListNode,RandomListNode> map = new HashMap<RandomListNode,RandomListNode>();
        RandomListNode p = pHead;
        RandomListNode q = new RandomListNode(-1);
        while(p!=null){
            RandomListNode t = new RandomListNode(p.label);
            map.put(p, t);
            p = p.next;
            q.next = t;
            q = t;
        }

        Set<Map.Entry<RandomListNode,RandomListNode>> set = map.entrySet();
        Iterator<Map.Entry<RandomListNode,RandomListNode>> it = set.iterator();
        while(it.hasNext()){
            Map.Entry<RandomListNode, RandomListNode> next = it.next();
            next.getValue().random = map.get(next.getKey().random);
        }
        return map.get(pHead);
        /*RandomListNode temp = pHead;
        RandomListNode head = null;
        RandomListNode p = null;
        int count = 0;
        if(pHead!=null) {
            head = new RandomListNode(pHead.label);
            count++;
            p = head;
            temp = temp.next;
            while(temp!=null){
                count++;
                p.next = new RandomListNode(temp.label);
                p = p.next;
                temp = temp.next;
            }
            temp = pHead;
            int[] index = new int[count];
            for(int i=0;i<count;i++){
                if(temp.random!=null){
                    RandomListNode temp1 = pHead;
                    while(temp1!=null){
                        if(temp1!=temp.random) {
                            index[i] += 1;
                            temp1 = temp1.next;
                        }
                        else
                            break;
                    }
                }
                temp = temp.next;
            }

            temp = pHead;
            p = head;
            for(int i=0;i<count;i++){
                if(temp.random!=null){
                    int index_Num = index[i];
                    int k = 0;
                    RandomListNode p1 = head;
                    while (p1!=null){
                        if(k<index_Num){
                            k++;
                            p1 = p1.next;
                        }
                        else{
                            p.random = p1;
                        }
                    }
                }
                p = p.next;
                temp = temp.next;
            }
        }
        return head;*/
    }

    //二叉搜索树与双向链表
    public TreeNode Convert(TreeNode pRootOfTree){
        List<TreeNode> list = new ArrayList<TreeNode>();
        if(pRootOfTree!=null) {
            inOrder(pRootOfTree, list);
            for(int i=0;i<list.size()-1;i++){
                TreeNode node = list.get(i);
                node.right = list.get(i+1);
            }
            list.get(list.size()-1).right = null;
            for(int i=list.size()-1;i>0;i--){
                TreeNode node = list.get(i);
                node.left = list.get(i-1);
            }
            list.get(0).left = null;
            return list.get(0);
        }
        return pRootOfTree;
    }
    public void inOrder(TreeNode root,List<TreeNode> list){
        if(root!=null){
            inOrder(root.left,list);
            list.add(root);
            inOrder(root.right,list);
        }
    }

    //字符串的排列
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> result = new ArrayList<String>();
        if(str==null||str.length()==0)
            return result;
        char[] chars = str.toCharArray();
        TreeSet<String> set = new TreeSet<String>();
        Permutation(chars,0,set);
        result.addAll(set);
        return result;
    }
    public void Permutation(char[] chars,int begin,TreeSet<String> result){
        if(begin==chars.length-1)
            result.add(String.valueOf(chars));
        else{
            for(int i=begin;i<chars.length;i++){
                swap(chars,begin,i);
                Permutation(chars,begin+1,result);
                swap(chars,begin,i);
            }
        }
    }
    public void swap(char[] chars,int a,int b){
        char temp = chars[a];
        chars[a] = chars[b];
        chars[b] = temp;
    }

    //数组中出现次数超过一半的数字
    public int MoreThanHalfNum_Solution(int [] array) {
        Map<Integer,Integer> map = new HashMap<Integer, Integer>();
        for(int i=0;i<array.length;i++){
            if(map.containsKey(array[i]))
                map.put(array[i],map.get(array[i])+1);
            else
                map.put(array[i],1);
        }
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            if(entry.getValue()>(array.length/2))
                return entry.getKey();
        }
        return 0;
    }

    //连续子数组的最大和
    public int FindGreatestSumOfSubArray(int[] array) {
        return 0;
    }

    //整数中1出现的次数（从1到n整数中1出现的次数）
    public int NumberOf1Between1AndN_Solution(int n) {
        int count = 0;
        for(int i=0;i<=n;i++)
            count += get1Num(i);
        return count;
    }
    public int get1Num(int a){
        String s = String.valueOf(a);
        int result = 0;
        for(int i=0;i<s.length();i++)
            if(s.charAt(i)=='1')
                result++;
        return result;
    }

    //把数组排成最小的数
    public String PrintMinNumber(int [] numbers) {
        return null;
    }

    //丑数
    public int GetUglyNumber_Solution(int index) {
        int count = 0;
        int number = 1;
        while(count<index){
            if(isUglyNumber(number))
                count++;
            number++;
        }
        return number;
    }
    private boolean isUglyNumber(int number) {
        while (number%2==0)
            number/=2;
        while(number%3==0)
            number/=3;
        while(number%5==0)
            number/=5;
        if(number==1)
            return true;
        else
            return false;
    }

    //第一个只出现一次的字符
    public int FirstNotRepeatingChar(String str) {
        Map<Character,Integer> map = new LinkedHashMap<Character, Integer>();
        for(int i=0;i<str.length();i++){
            char c = str.charAt(i);
            if(map.get(c)==null) {
                map.put(c, 1);
            }
            else{
                map.put(c,map.get(c)+1);
            }
        }
        for (Map.Entry<Character,Integer> entry:map.entrySet()){
            if(entry.getValue()==1){
                return str.indexOf(entry.getKey());
            }
        }
        return 0;
    }

    //数组中的逆序对
    public int InversePairs(int [] array) {
        int sum = 0;
        for(int i=0;i<array.length-1;i++){
            //int k = i;
            for(int j=i;j<array.length;j++){
                if(array[i]>array[j]){
                    sum++;
                }
            }
        }
        return sum%1000000007;
    }

    //两个链表的第一个公共结点
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        int len1 = getLen(pHead1);
        int len2 = getLen(pHead2);
        if(len1>len2){
            for(int i=1;i<=len1-len2;i++){
                pHead1 = pHead1.next;
            }
        }else {
            for(int i=1;i<=len2-len1;i++){
                pHead2 = pHead2.next;
            }
        }
        while((pHead1!=null&&pHead2!=null)&&pHead1.hashCode()!=pHead2.hashCode()){
            pHead1 = pHead1.next;
            pHead2 = pHead2.next;
        }
        if(pHead1==null||pHead2==null){
            return null;
        }
        return pHead1;
    }
    public int getLen(ListNode head){
        ListNode p = head;
        int count = 0;
        while(p!=null){
            count ++;
            p = p.next;
        }
        return count;
    }

    //数字在排序数组中出现的次数
    public int GetNumberOfK(int [] array , int k) {
        int low = 0;
        int high = array.length - 1;
        int count = 0;
        if(array.length==1&&array[0]==k)
            count++;
        while (low<high){
            int middle = (low+high)/2;
            if (array[middle]<k){
                low = middle + 1;
            }
            else if(array[middle]>k) {
                high = middle - 1;
            }
            else{
                count++;
                int i=middle - 1;
                while(i>=0&&array[i--]==k){
                    count++;
                }
                i = middle + 1;
                while(i<array.length&&array[i++]==k){
                    count++;
                }
                break;
            }
        }
        return count;
    }

    //二叉树的深度(输出二叉树上从根到所有叶子结点的路径)
    public int TreeDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        TreeNode p = root;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        List<Integer> list = new ArrayList<Integer>();
        countDepth(root,stack,list);
        Collections.sort(list);
        return list.get(list.size()-1);
    }
    public void countDepth(TreeNode p,Stack<TreeNode> stack,List<Integer> list){
        if(p!=null){
            stack.push(p);
            if(p.left==null&&p.right==null){
                list.add(stack.size());
            }
            else {
                countDepth(p.left,stack,list);
                countDepth(p.right,stack,list);
            }
            stack.pop();
        }
    }

    //判断是否是平衡二叉树
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

    ////num1,num2分别为长度为1的数组。传出参数
    //数组中只出现一次的数字
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        Map<Integer,Integer> map = new HashMap<Integer, Integer>();
        for(int i=0;i<array.length;i++){
            if(map.get(array[i])==null) {
                map.put(array[i],1);
            }else {
                map.put(array[i],map.get(array[i])+1);
            }
        }
        List<Integer> list = new ArrayList<Integer>();
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            if(entry.getValue()==1){
                list.add(entry.getKey());
            }
        }
        num1[0] = list.get(0);
        num2[0] = list.get(1);
    }

    public static void main ( String arg[] ) {
    }
}
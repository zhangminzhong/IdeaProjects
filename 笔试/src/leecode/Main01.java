package leecode;

import java.math.BigInteger;

/**
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 *
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 *
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Main01 {
    public static void main(String[] args) {
        ListNode l1,l2,temp;
        l1 = new ListNode(9);
//        l1.next = new ListNode(4);
//        l1.next.next = new ListNode(3);
        temp = l2 = new ListNode(1);
        for(int i=0;i<30;i++){
            temp.next = new ListNode(9);
            temp = temp.next;
        }
        Solution solution = new Solution();
        ListNode node = solution.addTwoNumbers(l1, l2);
        while(node!=null){
            System.out.println(node.val);
            node = node.next;
        }
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    static class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode head = null;
            ListNode temp = null;
            BigInteger a = getNumber(l1);
//            System.out.println("a="+a);
            BigInteger b = getNumber(l2);
//            System.out.println("b="+b);
            BigInteger c = a.add(b);
//            System.out.println("c="+c);
            if(c.bitLength()<1 && c.intValue()==0){
                head = new ListNode(0);
            }else{
                String cStr = c.toString();
                for(int i=0;i<cStr.length();i++){
                    ListNode p = new ListNode(Integer.parseInt(String.valueOf(cStr.charAt(i))));
                    if(head == null){
                        head = p;
                    }else{
                        p.next = head;
                        head = p;
                    }
                }
            }
            return head;
        }
        public BigInteger getNumber(ListNode list){
            BigInteger nubmer = BigInteger.ZERO;
            int k = 0;
            while(list!=null){
                if(k == 0){
                    nubmer = nubmer.add(BigInteger.valueOf(list.val));
//                    System.out.println("list.val="+list.val+",number="+nubmer);
                }else{
                    BigInteger e = BigInteger.ONE;
                    for(int m=1;m<=k;m++){
                        e = e.multiply(BigInteger.valueOf(10));
                    }
                    nubmer = nubmer.add(e.multiply(BigInteger.valueOf(list.val)));
//                    System.out.println("list.val="+list.val+",number="+nubmer);
                }
                k++;
                list=list.next;
            }
            return nubmer;
        }
    }
}

package leecode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 *
 * 如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。
 *
 * 假设环境不允许存储 64 位整数（有符号或无符号）。
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-integer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Main06 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.reverse(-123));
    }
    static class Solution {
        public int reverse(int x) {
            String number = String.valueOf(x);
            StringBuilder sb = new StringBuilder();
            for(int i=number.length()-1;i>=0;i--){
                sb.append(number.charAt(i));
            }
            String reverStr = sb.toString();
            long retNumber;
            if(reverStr.charAt(reverStr.length()-1)=='-'){
                retNumber = -Long.parseLong(reverStr.substring(0,reverStr.length()-1));
            }else{
                retNumber = Long.parseLong(reverStr);
            }
            if(retNumber>Integer.MAX_VALUE || retNumber<Integer.MIN_VALUE){
                return 0;
            }
            return (int)retNumber;
        }
    }






    public void test(){
        switch ('1'){
            case '1':;
            case '2':
                default:
        }
    }
}

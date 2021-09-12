package leecode;

import java.math.BigInteger;

/**
 * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
 *
 * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。例如，121 是回文，而 123 不是。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：x = 121
 * 输出：true
 * 示例 2：
 *
 * 输入：x = -121
 * 输出：false
 * 解释：从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 示例 3：
 *
 * 输入：x = 10
 * 输出：false
 * 解释：从右向左读, 为 01 。因此它不是一个回文数。
 * 示例 4：
 *
 * 输入：x = -101
 * 输出：false
 *  
 *
 * 提示：
 *
 * -231 <= x <= 231 - 1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Main08 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isPalindrome(10));
    }
    static class Solution {
        public boolean isPalindrome(int x) {
            String s = String.valueOf(x);
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<s.length();i++){
                sb.append(s.charAt(i));
            }
            return sb.toString().equals(sb.reverse().toString());
        }

        public boolean isPalindrome1(int x) {
            if(x<0){
                return false;
            }
            int temp=x;
            int result=0;
            int base = 0;
            while(temp>0){
                int e=1;
                for(int k=1;k<=base;k++){
                    e *= 10;
                }
                result += temp%10*e;
                temp /= 10;
                base++;
            }
            return result==x;
        }
    }
}

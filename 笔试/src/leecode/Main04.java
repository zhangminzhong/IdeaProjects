package leecode;

import sun.security.util.Length;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 * 示例 2：
 *
 * 输入：s = "cbbd"
 * 输出："bb"
 * 示例 3：
 *
 * 输入：s = "a"
 * 输出："a"
 * 示例 4：
 *
 * 输入：s = "ac"
 * 输出："a"
 *  
 *
 * 提示：
 *
 * 1 <= s.length <= 1000
 * s 仅由数字和英文字母（大写和/或小写）组成
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Main04 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String huiwen = solution.longestPalindrome("abababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababa");
        System.out.println("huiwen="+huiwen);
    }
    static class Solution {
        public String longestPalindrome(String s) {
            if (s.length() < 2)
                return s;
            int start = 0;
            int maxLen = 0;
            for (int i = 0; i < s.length() - 1; i++) {
                for (int j = i; j < s.length(); j++) {
                    //截取所有子串，如果截取的子串小于等于之前
                    //遍历过的最大回文串，直接跳过。因为截取
                    //的子串即使是回文串也不可能是最大的，所以
                    //不需要判断
                    if (j - i < maxLen)
                        continue;
                    if (isPalindrome(s, i, j)) {
                        if (maxLen < j - i + 1) {
                            start = i;
                            maxLen = j - i + 1;
                        }
                    }
                }
            }
            return s.substring(start, start + maxLen);
        }

        //判断是否是回文串
        private boolean isPalindrome(String s, int start, int end) {
            while (start < end) {
                if (s.charAt(start++) != s.charAt(end--))
                    return false;
            }
            return true;
        }
    }
}

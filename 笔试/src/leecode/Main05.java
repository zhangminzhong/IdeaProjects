package leecode;

import java.util.ArrayList;
import java.util.List;

/**
 * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
 *
 * 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
 *
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
 *
 * 请你实现这个将字符串进行指定行数变换的函数：
 *
 * string convert(string s, int numRows);
 *  
 *
 * 示例 1：
 *
 * 输入：s = "PAYPALISHIRING", numRows = 3
 * 输出："PAHNAPLSIIGYIR"
 * 示例 2：
 * 输入：s = "PAYPALISHIRING", numRows = 4
 * 输出："PINALSIGYAHRPI"
 * 解释：
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 * 示例 3：
 *
 * 输入：s = "A", numRows = 1
 * 输出："A"
 *  
 *
 * 提示：
 *
 * 1 <= s.length <= 1000
 * s 由英文字母（小写和大写）、',' 和 '.' 组成
 * 1 <= numRows <= 1000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zigzag-conversion
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Main05 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.convert("PAYPALISHIRING",4));
    }
    static class Solution {
        public String convert(String s, int numRows) {
            if(numRows==1){
                return s;
            }
            boolean goDown = false;
            int currRow = 0;
            List<StringBuilder> list = new ArrayList<StringBuilder>();
            for(int i=0;i<numRows;i++){
                list.add(new StringBuilder());
            }
            for(int i=0;i<s.length();i++){
                list.get(currRow).append(s.charAt(i));
                if((currRow==0) || (currRow==numRows-1)){
                    goDown = !goDown;
                }
                currRow += goDown ? 1 : -1;
            }
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<list.size();i++){
                sb.append(list.get(i));
            }
            return sb.toString();
        }
    }
}

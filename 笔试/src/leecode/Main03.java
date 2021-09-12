package leecode;

import java.util.LinkedList;

/**
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums1 = [1,3], nums2 = [2]
 * 输出：2.00000
 * 解释：合并数组 = [1,2,3] ，中位数 2
 * 示例 2：
 *
 * 输入：nums1 = [1,2], nums2 = [3,4]
 * 输出：2.50000
 * 解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
 * 示例 3：
 *
 * 输入：nums1 = [0,0], nums2 = [0,0]
 * 输出：0.00000
 * 示例 4：
 *
 * 输入：nums1 = [], nums2 = [1]
 * 输出：1.00000
 * 示例 5：
 *
 * 输入：nums1 = [2], nums2 = []
 * 输出：2.00000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Main03 {
    public static void main(String[] args) {
        int[] nums1 = {1,2};
        int[] nums2 = {3,4};
        Solution solution = new Solution();
        System.out.println(solution.findMedianSortedArrays(nums1,nums2));
    }

    static class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int i=0,j=0;
            LinkedList<Integer> list = new LinkedList<Integer>();
            while(i<nums1.length && j<nums2.length){
                if(nums1[i] < nums2[j]){
                    list.add(nums1[i++]);
                }else{
                    list.add(nums2[j++]);
                }
            }
            while(i<nums1.length){
                list.add(nums1[i++]);
            }
            while(j<nums2.length){
                list.add(nums2[j++]);
            }

            int index = list.size()/2;
            if(list.size()%2!=0){
                return list.get(index);
            }else{
                return (list.get(index-1)+list.get(index))*1.0/2;
            }
        }
    }
}

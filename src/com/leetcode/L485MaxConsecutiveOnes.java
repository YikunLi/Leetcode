package com.leetcode;

/**
 * @author liyikun 2017/06/01
 * @see
 *      <a
 *      href="https://leetcode.com/problems/max-consecutive-ones/#/description">
 *      485. Max Consecutive Ones</a>
 * @description
 *              Given a binary array, find the maximum number of consecutive 1s
 *              in this array.
 *              Example 1:
 *              Input: [1,1,0,1,1,1]
 *              Output: 3
 *              Explanation: The first two digits or the last three digits are
 *              consecutive 1s.
 *              The maximum number of consecutive 1s is 3.
 *              Note:
 *              The input array will only contain 0 and 1.
 *              The length of input array is a positive integer and will not
 *              exceed 10,000
 */
public class L485MaxConsecutiveOnes {

    public static void main(String[] args) {
        int[] nums = { 1, 1, 0, 1, 1, 1 };
        Solution solution = new Traverse();
        System.out.println(solution.findMaxConsecutiveOnes(nums));
    }

    public static interface Solution {

        public int findMaxConsecutiveOnes(int[] nums);
    }

    public static class Traverse implements Solution {

        @Override
        public int findMaxConsecutiveOnes(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            int max = 0;
            int total = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == 1) {
                    total++;
                } else {
                    max = Math.max(max, total);
                    total = 0;
                }
            }
            max = Math.max(max, total);
            return max;
        }

    }

}

package com.leetcode;

import java.util.Arrays;

/**
 * @author liyikun 2017/05/31
 *         Given an array of 2n integers, your task is to group these integers
 *         into n pairs of integer, say (a1, b1), (a2, b2), ..., (an, bn) which
 *         makes sum of min(ai, bi) for all i from 1 to n as large as possible.
 *         Example 1:
 *         Input: [1,4,3,2]
 *         Output: 4
 *         Explanation: n is 2, and the maximum sum of pairs is 4.
 *         Note:
 *         n is a positive integer, which is in the range of [1, 10000].
 *         All the integers in the array will be in the range of [-10000,
 *         10000].
 *         Subscribe to see which companies asked this question.
 */
public class L561ArrayPartitionI {

    public static void main(String[] args) {
        int[] array = { 1, 4, 3, 2 };
        Solution solution = new MergeSort();
        System.out.println(solution.arrayPairSum(array));
    }

    public static interface Solution {

        public int arrayPairSum(int[] nums);
    }

    /**
     * 最终转化为将2n个数排序，找所有奇数位下标的数据之和算法
     */
    public static class MergeSort implements Solution {

        @Override
        public int arrayPairSum(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            Arrays.sort(nums);
            int sum = 0;
            for (int i = 0; i < nums.length; i += 2) {
                sum += nums[i];
            }
            return sum;
        }

    }

}

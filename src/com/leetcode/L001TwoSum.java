package com.leetcode;

import java.util.Arrays;

/**
 * @author liyikun 2017/06/01
 * @see
 *      <a href="https://leetcode.com/problems/two-sum/#/description">1. Two
 *      Sum</a>
 * @description
 *              Given an array of integers, return indices of the two numbers
 *              such that they add up to a specific target.
 *              You may assume that each input would have exactly one solution,
 *              and you may not use the same element twice.
 *              Example:
 *              Given nums = [2, 7, 11, 15], target = 9,
 *              Because nums[0] + nums[1] = 2 + 7 = 9,
 *              return [0, 1].
 */
public class L001TwoSum {

    public static void main(String[] args) {
        int[] nums = { 2, 7, 11, 15 };
        Solution solution = new SolutionImpl();
        System.out.println(Arrays.toString(solution.twoSum(nums, 9)));
    }

    public static interface Solution {

        public int[] twoSum(int[] nums, int target);
    }

    public static class SolutionImpl implements Solution {

        @Override
        public int[] twoSum(int[] nums, int target) {
            if (nums == null || nums.length == 0) {
                return new int[] {};
            }
            for (int i = 0; i < nums.length; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[i] + nums[j] == target) {
                        return new int[] { i, j };
                    }
                }
            }
            return new int[] {};
        }

    }
}

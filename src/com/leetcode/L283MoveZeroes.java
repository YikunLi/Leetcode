package com.leetcode;

import java.util.Arrays;

/**
 * @author liyikun 2017/06/01
 * @see
 *      <a href="https://leetcode.com/problems/move-zeroes/#/description">283.
 *      Move Zeroes</a>
 * @description
 *              Given an array nums, write a function to move all 0's to the end
 *              of it while maintaining the relative order of the non-zero
 *              elements.
 *              For example, given nums = [0, 1, 0, 3, 12], after calling your
 *              function, nums should be [1, 3, 12, 0, 0].
 *              Note:
 *              You must do this in-place without making a copy of the array.
 *              Minimize the total number of operations.
 */
public class L283MoveZeroes {

    public static void main(String[] args) {
        int[] nums = { 0, 1, 0, 3, 12 };
        Solution solution = new SolutionImpl();
        solution.moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static interface Solution {

        public void moveZeroes(int[] nums);
    }

    public static class SolutionImpl implements Solution {

        @Override
        public void moveZeroes(int[] nums) {
            if (nums == null || nums.length == 0) {
                return;
            }
            int left = 0, right = 1;
            while (left < right && right < nums.length) {
                if (nums[left] == 0) {
                    if (nums[right] == 0) {
                        right++;
                    } else {
                        int temp = nums[left];
                        nums[left] = nums[right];
                        nums[right] = temp;
                        left++;
                        right++;
                    }
                } else {
                    if (left == right - 1) {
                        right++;
                    }
                    left++;
                }
            }
        }

    }
}

package com.leetcode;

/**
 * @author liyikun 2017/06/05
 * @see
 *      <a
 *      href="https://leetcode.com/problems/missing-number/#/description">268.
 *      Missing Number</a>
 * @description
 *              Given an array containing n distinct numbers taken from 0, 1, 2,
 *              ..., n, find the one that is missing from the array.
 *              For example,
 *              Given nums = [0, 1, 3] return 2.
 *              Note:
 *              Your algorithm should run in linear runtime complexity. Could
 *              you implement it using only constant extra space complexity?
 */
public class L268MissingNumber {

    public static void main(String[] args) {
        Solution solution = new NotSorted();
        System.out.println(solution.missingNumber(new int[] { 0, 1, 3 }));
        System.out.println(
                solution.missingNumber(new int[] { 2, 0, 1, 4, 7, 6, 5 }));
    }

    public static interface Solution {

        public int missingNumber(int[] nums);
    }

    public static class IfSorted implements Solution {

        @Override
        public int missingNumber(int[] nums) {
            if (nums == null) {
                return 0;
            }
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != i) {
                    return i;
                }
            }
            return nums.length;
        }

    }

    public static class NotSorted implements Solution {

        @Override
        public int missingNumber(int[] nums) {
            if (nums == null) {
                return 0;
            }
            int position = -1;
            for (int i = 0; i < nums.length;) {
                // System.out.println("i : " + i + " position : " + position);
                // System.out.println(Arrays.toString(nums));
                if (nums[i] == i) {
                    i++;
                    continue;
                }
                if (nums[i] >= nums.length) {
                    position = i;
                    i++;
                    continue;
                }
                int temp = nums[i];
                nums[i] = nums[temp];
                nums[temp] = temp;
            }
            if (position == -1) {
                return nums.length;
            }
            return position;
        }

    }
}

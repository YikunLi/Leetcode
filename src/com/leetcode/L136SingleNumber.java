package com.leetcode;

/**
 * @author liyikun 2017/06/01
 * @see
 *      <a href="https://leetcode.com/problems/single-number/#/description">136.
 *      Single Number</a>
 * @description
 *              Given an array of integers, every element appears twice except
 *              for one. Find that single one.
 *              Note:
 *              Your algorithm should have a linear runtime complexity. Could
 *              you implement it without using extra memory?
 */
public class L136SingleNumber {

    public static void main(String[] args) {
        Solution solution = new Hash();
        System.out.println(solution.singleNumber(new int[] { 2, 4, 2 }));
    }

    public static interface Solution {

        public int singleNumber(int[] nums);
    }

    public static class Hash implements Solution {

        @Override
        public int singleNumber(int[] nums) {
            if (nums == null || nums.length == 0) {
                return -1;
            } else if (nums.length == 1) {
                return nums[0];
            }
            int[] hashMap = new int[nums.length / 2 + 1];
            int[] hashCount = new int[nums.length / 2 + 1];
            for (int i = 0; i < nums.length; i++) {
                int t = Math.abs(nums[i] % hashMap.length);
                while (hashCount[t] != 0 && hashMap[t] != nums[i]) {
                    t = (t + 1) % hashMap.length;
                }
                hashCount[t]++;
                hashMap[t] = nums[i];
            }
            for (int i = 0; i < hashMap.length; i++) {
                if (hashCount[i] == 1) {
                    return hashMap[i];
                }
            }
            return 0;
        }

    }
}

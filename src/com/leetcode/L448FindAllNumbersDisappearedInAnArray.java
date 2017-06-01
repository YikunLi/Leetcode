package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liyikun 2017/06/01
 * @see
 *      <a href=
 *      "https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/#/description"
 *      >448. Find All Numbers Disappeared in an Array</a>
 * @description
 *              Given an array of integers where 1 ≤ a[i] ≤ n (n = size of
 *              array), some elements appear twice and others appear once.
 *              Find all the elements of [1, n] inclusive that do not appear in
 *              this array.
 *              Could you do it without extra space and in O(n) runtime? You may
 *              assume the returned list does not count as extra space.
 *              Example:
 *              Input:
 *              [4,3,2,7,8,2,3,1]
 *              Output:
 *              [5,6]
 */
public class L448FindAllNumbersDisappearedInAnArray {

    public static void main(String[] args) {
        Solution solution = new Traverse();
        System.out.println(solution
                .findDisappearedNumbers(new int[] { 4, 3, 2, 7, 8, 2, 3, 1 }));
    }

    public static interface Solution {

        public List<Integer> findDisappearedNumbers(int[] nums);
    }

    public static class Traverse implements Solution {

        @Override
        public List<Integer> findDisappearedNumbers(int[] nums) {
            List<Integer> list = new ArrayList<Integer>();
            if (nums == null || nums.length == 0) {
                return list;
            }
            boolean[] numbers = new boolean[nums.length];
            for (int i = 0; i < nums.length; i++) {
                numbers[nums[i] - 1] = true;
            }
            for (int i = 0; i < numbers.length; i++) {
                if (!numbers[i]) {
                    list.add(i + 1);
                }
            }
            return list;
        }

    }
}

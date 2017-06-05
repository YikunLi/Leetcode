package com.leetcode;

import java.util.Arrays;

/**
 * @author liyikun 2017/06/05
 * @see
 *      <a href="https://leetcode.com/problems/plus-one/#/description">66. Plus
 *      One</a>
 * @description
 *              Given a non-negative integer represented as a non-empty array of
 *              digits, plus one to the integer.
 *              You may assume the integer do not contain any leading zero,
 *              except the number 0 itself.
 *              The digits are stored such that the most significant digit is at
 *              the head of the list.
 */
public class L066PlusOne {

    public static void main(String[] args) {
        Solution solution = new SolutionImpl();
        System.out.println(
                Arrays.toString(solution.plusOne(new int[] { 9, 9, 9 })));
    }

    public static interface Solution {

        public int[] plusOne(int[] digits);
    }

    public static class SolutionImpl implements Solution {

        @Override
        public int[] plusOne(int[] digits) {
            if (digits == null || digits.length == 0) {
                return digits;
            }
            int carry = 1;
            int[] array = new int[digits.length];
            for (int i = 0; i < digits.length; i++) {
                carry += digits[digits.length - i - 1];
                array[digits.length - i - 1] = carry % 10;
                carry /= 10;
            }
            if (carry > 0) {
                int[] arrayTemp = new int[array.length + 1];
                arrayTemp[0] = carry;
                for (int i = 0; i < array.length; i++) {
                    arrayTemp[i + 1] = array[i];
                }
                array = arrayTemp;
            }
            return array;
        }
    }

}

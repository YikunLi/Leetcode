package com.leetcode;

/**
 * @author liyikun 2017/06/05
 * @see
 *      <a href="https://leetcode.com/problems/add-strings/#/description">415.
 *      Add Strings</a>
 * @description
 *              Given two non-negative integers num1 and num2 represented as
 *              string, return the sum of num1 and num2.
 *              Note:
 *              The length of both num1 and num2 is < 5100.
 *              Both num1 and num2 contains only digits 0-9.
 *              Both num1 and num2 does not contain any leading zero.
 *              You must not use any built-in BigInteger library or convert the
 *              inputs to integer directly.
 */
public class L415AddStrings {

    public static void main(String[] args) {
        Solution solution = new SolutionImpl();
        System.out.println(solution.addStrings("12345", "6789"));
        System.out.println(solution.addStrings("1", "9"));
    }

    public static interface Solution {

        public String addStrings(String num1, String num2);
    }

    public static class SolutionImpl implements Solution {

        @Override
        public String addStrings(String num1, String num2) {
            if ((num1 == null || num1.length() == 0)
                    && (num2 == null || num2.length() == 0)) {
                return null;
            } else if (num1 == null || num1.length() == 0) {
                return num2;
            } else if (num2 == null || num2.length() == 0) {
                return num1;
            }
            StringBuilder builder = new StringBuilder();
            int carry = 0;
            for (int i = 0; i < num1.length() || i < num2.length(); i++) {
                if (i < num1.length()) {
                    carry += num1.charAt(num1.length() - i - 1) - '0';
                }
                if (i < num2.length()) {
                    carry += num2.charAt(num2.length() - i - 1) - '0';
                }
                builder.insert(0, carry % 10);
                carry /= 10;
            }
            if (carry != 0) {
                builder.insert(0, carry);
            }
            return builder.toString();
        }

    }

}

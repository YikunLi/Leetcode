package com.leetcode;

/**
 * @author liyikun 2017/06/05
 * @see
 *      <a
 *      href="https://leetcode.com/problems/palindrome-number/#/description">9.
 *      Palindrome Number</a>
 * @description
 *              Determine whether an integer is a palindrome. Do this without
 *              extra space.
 */
public class L009PalindromeNumber {

    public static void main(String[] args) {
        Solution solution = new SolutionImpl();
        System.out.println(solution.isPalindrome(-2147447412));
    }

    public static interface Solution {

        public boolean isPalindrome(int x);
    }

    public static class SolutionImpl implements Solution {

        @Override
        public boolean isPalindrome(int x) {
            if (x < 0) {
                return false;
            } else if (x < 10) {
                return true;
            }
            int divider = 1, temp = x;
            while (temp / 10 != 0) {
                divider *= 10;
                temp /= 10;

            }
            while (x > 1 || x < -1) {
                System.out.println(x / divider);
                System.out.println(x % 10);
                if (x / divider != x % 10) {
                    return false;
                }
                x -= x / divider * divider;
                x /= 10;
                divider /= 100;
                System.out.println(x);
            }
            return true;
        }

    }
}

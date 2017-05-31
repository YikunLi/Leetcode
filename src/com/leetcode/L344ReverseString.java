package com.leetcode;

/**
 * @author liyikun 2017/05/31
 * @see <a
 *      href="https://leetcode.com/problems/reverse-string/#/description">344.
 *      Reverse String</a>
 * @description
 *              Write a function that takes a string as input and returns the
 *              string reversed.
 *              Example:
 *              Given s = "hello", return "olleh".
 */
public class L344ReverseString {

    public static void main(String[] args) {
        Solution solution = new SolutionImpl();
        System.out.println(solution.reverseString("hello"));
    }

    public static interface Solution {

        public String reverseString(String s);
    }

    public static class SolutionImpl implements Solution {

        @Override
        public String reverseString(String s) {
            if (s == null || s.length() == 0 || s.length() == 1) {
                return s;
            }
            StringBuilder reverseBuilder = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                reverseBuilder.insert(0, s.charAt(i));
            }
            return reverseBuilder.toString();
        }

    }

}

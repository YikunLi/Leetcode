package com.leetcode;

/**
 * @author liyikun 2017/06/01
 * @see
 *      <a href="https://leetcode.com/problems/add-digits/#/description">258.
 *      Add Digits</a>
 * @description
 *              Given a non-negative integer num, repeatedly add all its digits
 *              until the result has only one digit.
 *              For example:
 *              Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2.
 *              Since 2 has only one digit, return it.
 *              Follow up:
 *              Could you do it without any loop/recursion in O(1) runtime?
 */
public class L258AddDigits {

    public static void main(String[] args) {
        Solution solution = new SolutionImpl();
        System.out.println(solution.addDigits(38));
        System.out.println(solution.addDigits(1));
    }

    public static interface Solution {

        public int addDigits(int num);
    }

    public static class SolutionImpl implements Solution {

        @Override
        public int addDigits(int num) {
            while (num >= 10) {
                int temp = 0;
                while (num != 0) {
                    temp += num % 10;
                    num /= 10;
                }
                num = temp;
            }
            return num;
        }
    }

}

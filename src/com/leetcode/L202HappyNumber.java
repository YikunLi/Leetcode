package com.leetcode;

/**
 * @author liyikun 2017/06/05
 * @see
 *      <a
 *      href="https://leetcode.com/problems/happy-number/#/description">
 *      202. Happy Number</a>
 * @description
 *              Write an algorithm to determine if a number is "happy".
 *              A happy number is a number defined by the following process:
 *              Starting with any positive integer, replace the number by the
 *              sum of the squares of its digits, and repeat the process until
 *              the number equals 1 (where it will stay), or it loops endlessly
 *              in a cycle which does not include 1. Those numbers for which
 *              this process ends in 1 are happy numbers.
 *              Example: 19 is a happy number
 *              12 + 92 = 82
 *              82 + 22 = 68
 *              62 + 82 = 100
 *              12 + 02 + 02 = 1
 */
public class L202HappyNumber {

    public static void main(String[] args) {
        Solution solution = new SolutionImpl();
        System.out.println(solution.isHappy(19));
        System.out.println(solution.isHappy(7));
    }

    public static interface Solution {

        public boolean isHappy(int n);
    }

    public static class SolutionImpl implements Solution {

        @Override
        public boolean isHappy(int n) {
            int cyclerNumber = -1;
            do {
                int temp = n;
                n = 0;
                while (temp != 0) {
                    n += (temp % 10) * (temp % 10);
                    temp /= 10;
                }
                if (n < 10) {
                    if (cyclerNumber == n) {
                        break;
                    } else {
                        cyclerNumber = n;
                    }
                }
            } while (n != 1);
            return n == 1;
        }

    }
}

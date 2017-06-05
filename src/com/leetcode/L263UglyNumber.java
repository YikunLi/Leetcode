package com.leetcode;

/**
 * @author liyikun 2017/06/05
 * @see
 *      <a href="https://leetcode.com/problems/ugly-number/#/description">263.
 *      Ugly Number</a>
 * @description
 *              Write a program to check whether a given number is an ugly
 *              number.Ugly numbers are positive numbers whose prime factors
 *              only include 2, 3, 5. For example, 6, 8 are ugly while 14 is not
 *              ugly since it includes another prime factor 7. Note that 1 is
 *              typically treated as an ugly number.
 */
public class L263UglyNumber {

    public static void main(String[] args) {
        Solution solution = new SolutionImpl();
        System.out.println(solution.isUgly(1));
        System.out.println(solution.isUgly(6));
        System.out.println(solution.isUgly(8));
        System.out.println(solution.isUgly(14));
    }

    public static interface Solution {

        public boolean isUgly(int num);
    }

    public static class SolutionImpl implements Solution {

        @Override
        public boolean isUgly(int num) {
            if (num <= 0) {
                return false;
            } else if (num <= 5) {
                return true;
            }
            num = this.divide(num, 2);
            num = this.divide(num, 3);
            num = this.divide(num, 5);
            return num == 1;
        }

        private int divide(int number, int divider) {
            while (number % divider == 0) {
                number /= divider;
            }
            return number;
        }

    }
}

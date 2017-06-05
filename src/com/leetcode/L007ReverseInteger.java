package com.leetcode;

/**
 * @author liyikun 2017/06/05
 * @see
 *      <a href="https://leetcode.com/problems/reverse-integer/#/description">7.
 *      Reverse Integer</a>
 * @description
 *              Reverse digits of an integer.
 *              Example1: x = 123, return 321
 *              Example2: x = -123, return -321
 */
public class L007ReverseInteger {

    public static void main(String[] args) {
        Solution solution = new SolutionImpl();
        System.out.println(solution.reverse(123));
        System.out.println(solution.reverse(-123));
        System.out.println(solution.reverse(1534236469));
        System.out.println(solution.reverse(-2147483648));
    }

    public static interface Solution {

        public int reverse(int x);
    }

    public static class SolutionImpl implements Solution {

        @Override
        public int reverse(int x) {
            if (x < 10 && x > -10) {
                return x;
            }
            long sum = 0;
            while (x != 0) {
                sum = sum * 10 + x % 10;
                if (sum > Integer.MAX_VALUE || sum < Integer.MIN_VALUE) {
                    return 0;
                }
                x /= 10;
            }
            return (int) sum;
        }

    }
}

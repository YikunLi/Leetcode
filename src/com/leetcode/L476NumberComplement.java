package com.leetcode;

/**
 * @author liyikun 2017/05/31
 * @see
 *      <a href="https://leetcode.com/problems/number-complement/#/description">
 *      476. Number Complement</a>
 * @description
 *              Given a positive integer, output its complement number. The
 *              complement strategy is to flip the bits of its binary
 *              representation.
 *              Note:
 *              The given integer is guaranteed to fit within the range of a
 *              32-bit signed integer. You could assume no leading zero bit in
 *              the integer’s binary representation.
 *              Example 1:
 *              Input: 5
 *              Output: 2
 *              Explanation: The binary representation of 5 is 101 (no leading
 *              zero bits), and its complement is 010. So you need to output 2.
 *              Example 2:
 *              Input: 1
 *              Output: 0
 *              Explanation: The binary representation of 1 is 1 (no leading
 *              zero F * bits), and its complement is 0. So you need to output
 *              0.
 */
public class L476NumberComplement {

    public static void main(String[] args) {
        Solution solution = new SolutionImpl();
        System.out.println(solution.findComplement(5));
        System.out.println(solution.findComplement(1));
        System.out.println(solution.findComplement(2));
    }

    public static interface Solution {
        public int findComplement(int num);
    }

    public static class SolutionImpl implements Solution {

        @Override
        public int findComplement(int num) {
            final int RADIX = 2;
            int complement = 0;
            int figure = 1;
            while (num != 0) {
                complement += (1 - (num % RADIX)) * figure;
                num /= RADIX;
                figure *= 2;
            }
            return complement;
        }
    }

}

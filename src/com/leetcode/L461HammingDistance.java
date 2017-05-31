package com.leetcode;

/**
 * @author liyikun 2017/05/31
 * @see
 *      <a
 *      href="https://leetcode.com/problems/hamming-distance/#/description">461.
 *      Hamming Distance</a>
 * @description
 *              The Hamming distance between two integers is the number of
 *              positions at which the corresponding bits are different. Given
 *              two integers x and y, calculate the Hamming distance.
 *              Note:
 *              0 ≤ x, y < 231.
 *              Example:
 *              Input: x = 1, y = 4
 *              Output: 2
 *              Explanation:
 *              1 (0 0 0 1)
 *              4 (0 1 0 0)
 *              _____↑___↑
 *              The above arrows point to positions where the corresponding bits
 *              are different.
 */
public class L461HammingDistance {

    public static void main(String[] args) {
        Solution solution = new SolutionImpl();
        System.out.println(solution.hammingDistance(1, 4));
    }

    public static interface Solution {

        public int hammingDistance(int x, int y);
    }

    public static class SolutionImpl implements Solution {

        @Override
        public int hammingDistance(int x, int y) {
            final int RADIX = 2;
            int distance = 0;
            while (x != 0 || y != 0) {
                int xBit = 0;
                if (x != 0) {
                    xBit = x % RADIX;
                    x /= RADIX;
                }
                int yBit = 0;
                if (y != 0) {
                    yBit = y % RADIX;
                    y /= RADIX;
                }
                if (xBit != yBit) {
                    distance++;
                }
            }
            return distance;
        }

    }
}

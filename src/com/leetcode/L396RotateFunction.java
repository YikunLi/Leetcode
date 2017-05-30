package com.leetcode;

/**
 * Given an array of integers A and let n to be its length.
 * Assume Bk to be an array obtained by rotating the array A k positions
 * clock-wise,
 * we define a "rotation function" F on A as follow:
 * F(k) = 0 * Bk[0] + 1 * Bk[1] + ... + (n-1) * Bk[n-1].
 * Calculate the maximum value of F(0), F(1), ..., F(n-1).
 * Note:
 * n is guaranteed to be less than 105.
 * Example:
 * A = [4, 3, 2, 6]
 * F(0) = (0 * 4) + (1 * 3) + (2 * 2) + (3 * 6) = 0 + 3 + 4 + 18 = 25
 * F(1) = (0 * 6) + (1 * 4) + (2 * 3) + (3 * 2) = 0 + 4 + 6 + 6 = 16
 * F(2) = (0 * 2) + (1 * 6) + (2 * 4) + (3 * 3) = 0 + 6 + 8 + 9 = 23
 * F(3) = (0 * 3) + (1 * 2) + (2 * 6) + (3 * 4) = 0 + 2 + 12 + 12 = 26
 * So the maximum value of F(0), F(1), F(2), F(3) is F(3) = 26.
 */
public class L396RotateFunction {

    public static void main(String[] args) {
        int[] A = { 4, 3, 2, 6 };
        Solution solution = new ExhaustionReduceSpace();
        System.out.println(solution.maxRotateFunction(A));
    }

    public static interface Solution {

        public int maxRotateFunction(int[] A);
    }

    /**
     * One solution use exhaustion
     */
    public static class Exhaustion implements Solution {

        @Override
        public int maxRotateFunction(int[] A) {
            if (A == null || A.length == 0 || A.length == 1) {
                return 0;
            }
            // list rotate arrays
            int[][] arrays = new int[A.length][A.length];
            for (int i = 0; i < arrays.length; i++) {
                arrays[i] = new int[A.length];
                for (int j = 0; j < arrays[i].length; j++) {
                    arrays[i][j] = A[(i + j) % A.length];
                }
                // System.out.println(Arrays.toString(arrays[i]));
            }
            // compare the value
            int maxValue = Integer.MIN_VALUE;
            for (int i = 0; i < arrays.length; i++) {
                int fk = 0;
                for (int j = 1; j < arrays[i].length; j++) {
                    fk += arrays[i][j] * j;
                }
                maxValue = maxValue > fk ? maxValue : fk;
            }
            return maxValue;
        }

    }

    /**
     * Reduce Space of {@link Exhaustion}}
     */
    public static class ExhaustionReduceSpace extends Exhaustion {

        @Override
        public int maxRotateFunction(int[] A) {
            if (A == null || A.length == 0 || A.length == 1) {
                return 0;
            }
            int maxValue = Integer.MIN_VALUE;
            for (int i = 0; i < A.length; i++) {
                int fk = 0;
                for (int j = 1; j < A.length; j++) {
                    int value = A[(i + j) % A.length];
                    fk += value * j;
                }
                maxValue = maxValue > fk ? maxValue : fk;
            }
            return maxValue;
        }

    }

}
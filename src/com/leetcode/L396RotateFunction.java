package com.leetcode;

/**
 * @author liyikun 2017/05/30
 * @see
 *      <a
 *      href="https://leetcode.com/problems/rotate-function/#/description">396.
 *      Rotate Function</a>
 * @description
 *              Given an array of integers A and let n to be its length. Assume
 *              Bk to be an array obtained by rotating the array A k positions
 *              clock-wise, we define a "rotation function" F on A as follow:
 *              F(k) = 0 * Bk[0] + 1 * Bk[1] + ... + (n-1) * Bk[n-1].
 *              Calculate the maximum value of F(0), F(1), ..., F(n-1).
 *              Note:
 *              n is guaranteed to be less than 105.
 *              Example:
 *              A = [4, 3, 2, 6]
 *              F(0) = (0 * 4) + (1 * 3) + (2 * 2) + (3 * 6) = 0 + 3 + 4 + 18 =
 *              25
 *              F(1) = (0 * 6) + (1 * 4) + (2 * 3) + (3 * 2) = 0 + 4 + 6 + 6 =
 *              16
 *              F(2) = (0 * 2) + (1 * 6) + (2 * 4) + (3 * 3) = 0 + 6 + 8 + 9 =
 *              23
 *              F(3) = (0 * 3) + (1 * 2) + (2 * 6) + (3 * 4) = 0 + 2 + 12 + 12 =
 *              26
 *              So the maximum value of F(0), F(1), F(2), F(3) is F(3) = 26.
 */
public class L396RotateFunction {

    public static void main(String[] args) {
        int[] A = { 4, 3, 2, 6 };
        Solution solution = new DynamicProgramming();
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
                    arrays[i][j] = A[((A.length - i) % A.length + j)
                            % A.length];
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
                    int value = A[((A.length - i) % A.length + j) % A.length];
                    fk += value * j;
                }
                maxValue = maxValue > fk ? maxValue : fk;
            }
            return maxValue;
        }

    }

    /**
     * Derivation of equation:
     * F(k) = 0 * Bk[0] + 1 * Bk[1] + ... + (n - 1) * Bk[n-1].
     * F(k+1) = 0 * Bk[n-1] + 1 * Bk[0] + 2 * Bk[1] + ... + (n-1) * Bk[n-2]
     * F(k+1) - F(k) = Bk[0] + Bk[1] + ... + Bk[n-2] + (1 - n) * Bk[n-1].
     * F(k+1) - F(k) = Sum - n * Bk[n-1].
     * F(k+1) = F(k) + Sum - n * Bk[n-1].
     * Example:
     * A = [4, 3, 2, 6]
     * F(0) = F(3) + Sum - 4 * 4;
     * Sum = 4 + 3 + 2 + 6 = 15;
     * F(0) = 25
     * F(1) = 26
     * 25 = 26 + 15 - 16;
     */
    public static class DynamicProgramming implements Solution {

        @Override
        public int maxRotateFunction(int[] A) {
            if (A == null || A.length == 0 || A.length == 1) {
                return 0;
            }
            // Compute sum and F(0)
            int sum = 0;
            int f0 = 0;
            for (int i = 0; i < A.length; i++) {
                sum += A[i];
                f0 += i * A[i];
            }
            // Compare
            int maxValue = f0;
            int fk = f0;
            for (int i = 1; i < A.length; i++) {
                fk += sum - A.length * A[A.length - i];
                // System.out.println(fk);
                maxValue = maxValue > fk ? maxValue : fk;
            }
            return maxValue;
        }

    }

}

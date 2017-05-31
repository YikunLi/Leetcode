package com.leetcode;

/**
 * @author liyikun 2017/05/31
 * @see
 *      <a
 *      href="https://leetcode.com/problems/reshape-the-matrix/#/description">
 *      566. Reshape the Matrix</a>
 * @description
 *              In MATLAB, there is a very useful function called 'reshape',
 *              which can reshape a matrix into a new one with different size
 *              but keep its original data. You're given a matrix represented by
 *              a two-dimensional array, and two positive integers r and c
 *              representing the row number and column number of the wanted
 *              reshaped matrix, respectively. The reshaped matrix need to be
 *              filled with all the elements of the original matrix in the same
 *              row-traversing order as they were. If the 'reshape' operation
 *              with given parameters is possible and legal, output the new
 *              reshaped matrix; Otherwise, output the original matrix.
 *              Example 1:
 *              Input:
 *              nums = [[1,2], [3,4]]
 *              r = 1, c = 4
 *              Output:
 *              [[1,2,3,4]]
 *              Explanation:
 *              The row-traversing of nums is [1,2,3,4]. The new reshaped matrix
 *              is a 1 * 4 matrix, fill it row by row by using the previous
 *              list.
 *              Example 2:
 *              Input:
 *              nums =[[1,2], [3,4]]
 *              r = 2, c = 4
 *              Output:
 *              [[1,2], [3,4]]
 *              Explanation:
 *              There is no way to reshape a 2 * 2 matrix to a 2 * 4 matrix. So
 *              output the original matrix.
 *              Note:
 *              The height and width of the given matrix is in range [1, 100].
 *              The given r and c are all positive.
 */
public class L566ReshapeTheMatrix {

    public static void main(String[] args) {
        Solution solution = new SolutionImpl();
        int[][] nums = { { 1, 2 }, { 3, 4 } };
        print(solution.matrixReshape(nums, 1, 4));
        print(solution.matrixReshape(nums, 2, 4));
    }

    private static void print(int[][] nums) {
        for (int[] array : nums) {
            for (int next : array) {
                System.out.print(next + " ");
            }
            System.out.println();
        }
    }

    public static interface Solution {

        public int[][] matrixReshape(int[][] nums, int r, int c);
    }

    public static class SolutionImpl implements Solution {

        @Override
        public int[][] matrixReshape(int[][] nums, int r, int c) {
            if (nums == null || nums.length == 0) {
                return nums;
            }
            int[][] reshapeMatrix = new int[r][c];
            int m = 0, n = 0;
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    if (n == nums[m].length) {
                        m++;
                        n = 0;
                    }
                    if (m == nums.length && j < c) {
                        // output the original matrix.
                        return nums;
                    }
                    reshapeMatrix[i][j] = nums[m][n++];
                }
            }
            if (m < nums.length - 1 || n < nums[m].length) {
                // output the original matrix.
                return nums;
            }
            return reshapeMatrix;
        }

    }
}

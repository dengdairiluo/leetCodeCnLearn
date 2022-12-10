package com.yuren.leetcodecnlearn.Q400;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2021-11-18 23:38
 */
public class Q304 {

    int[][] preSum;

    public Q304(int[][] matrix) {
        preSum = new int[matrix.length][matrix[0].length];
        for (int row = 0; row < preSum.length; row++) {
            for (int col = 0; col < preSum[row].length; col++) {
                preSum[row][col] = getMatrixNum(preSum, row - 1, col)
                        + getMatrixNum(preSum, row, col - 1)
                        - getMatrixNum(preSum, row - 1, col - 1)
                        + matrix[row][col];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = getMatrixNum(preSum, row2, col2)
                + getMatrixNum(preSum, row1 - 1, col1 - 1)
                - getMatrixNum(preSum, row2, col1 - 1)
                - getMatrixNum(preSum, row1 - 1, col2);
        return sum;
    }

    public int getMatrixNum(int[][] matrix, int row, int col) {
        if (row < 0 || col < 0) {
            return 0;
        }
        return matrix[row][col];
    }
}

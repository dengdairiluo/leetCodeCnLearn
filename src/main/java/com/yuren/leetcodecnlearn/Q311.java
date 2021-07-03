package com.yuren.leetcodecnlearn;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2021-07-03 23:00
 */
public class Q311 {
    public int[][] multiply(int[][] A, int[][] B) {
        if (A.length == 0 || B.length == 0) {
            return new int[0][0];
        }
        int[][] res = new int[A.length][B[0].length];
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[0].length; j++) {
                res[i][j] = calculate(A, B, i, j);
            }
        }
        return res;
    }

    private int calculate(int[][] A ,int[][] B, int row, int col) {
        int sum = 0;
        for (int j = 0; j < A[row].length; j++) {
            sum = sum + A[row][j] * B[j][col];
        }
        return sum;
    }
}

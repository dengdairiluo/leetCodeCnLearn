package com.yuren.leetcodecnlearn;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2021-07-24 20:48
 */
public class Q1314 {
    int[][] dp;

    public int[][] matrixBlockSum(int[][] mat, int k) {
        int m = mat.length, n = mat[0].length;
        dp = new int[m][n];
        dp[0][0] = mat[0][0];
        //第一列
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + mat[i][0];
        }
        //第一行
        for (int i = 1; i < n; i++) {
            dp[0][i] = dp[0][i - 1] + mat[0][i];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1] + mat[i][j];
            }
        }

        int[][] res = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int r1 = Math.max(i - k, 0);
                int r2 = Math.min(i + k, m - 1);
                int c1 = Math.max(j - k, 0);
                int c2 = Math.min(j + k, n - 1);

                res[i][j] = sumRegion(r1, c1, r2, c2);
            }
        }
        return res;
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if (row1 == 0 && col1 == 0) {
            return dp[row2][col2];
        } else if (row1 == 0) {
            return dp[row2][col2] - dp[row2][col1 - 1];
        } else if (col1 == 0) {
            return dp[row2][col2] - dp[row1 - 1][col2];
        } else {
            return dp[row2][col2] - dp[row1 - 1][col2] - dp[row2][col1 - 1] + dp[row1 - 1][col1 - 1];
        }
    }

}

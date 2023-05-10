package com.yuren.leetcodecnlearn.Q1500;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-05-10 23:53
 */
public class Q1594 {
    private static final int MOD = 1000000000 + 7;

    public int maxProductPath(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        long[][] maxGt = new long[m][n];
        long[][] minLt = new long[m][n];

        maxGt[0][0] = minLt[0][0] = grid[0][0];
        for (int i = 1; i < n; i++) {
            maxGt[0][i] = minLt[0][i] = maxGt[0][i - 1] * grid[0][i];
        }
        for (int i = 1; i < m; i++) {
            maxGt[i][0] = minLt[i][0] = maxGt[i - 1][0] * grid[i][0];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (grid[i][j] >= 0) {
                    maxGt[i][j] = Math.max(maxGt[i][j - 1], maxGt[i - 1][j]) * grid[i][j];
                    minLt[i][j] = Math.min(minLt[i][j - 1], minLt[i - 1][j]) * grid[i][j];
                } else {
                    maxGt[i][j] = Math.min(minLt[i][j - 1], minLt[i - 1][j]) * grid[i][j];
                    minLt[i][j] = Math.max(maxGt[i][j - 1], maxGt[i - 1][j]) * grid[i][j];
                }
            }
        }
        if (maxGt[m - 1][n - 1] < 0) {
            return -1;
        } else {
            return (int) (maxGt[m - 1][n - 1] % MOD);
        }
    }
}

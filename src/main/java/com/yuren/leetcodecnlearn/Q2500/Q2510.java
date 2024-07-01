package com.yuren.leetcodecnlearn.Q2500;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-07-01 下午11:07
 */
public class Q2510 {
    public boolean isThereAPath(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        if ((m + n) % 2 == 0) {
            return false;
        }
        int delta = (m + n - 1) / 2;
        boolean[][][] dp = new boolean[m][n][m + n];
        int topValue = grid[0][0] == 1 ? delta + 1 : delta - 1;
        int leftValue = topValue;
        dp[0][0][topValue] = true;
        for (int j = 1; j < n && topValue >= 0; j++) {
            int diff = grid[0][j] == 1 ? 1 : -1;
            topValue += diff;
            if (topValue >= 0 && topValue < m + n) {
                dp[0][j][topValue] = true;
            }
        }
        for (int i = 1; i < m && leftValue >= 0; i++) {
            int diff = grid[i][0] == 1 ? 1 : -1;
            leftValue += diff;
            if (leftValue >= 0 && leftValue < m + n) {
                dp[i][0][leftValue] = true;
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                int diff = grid[i][j] == 1 ? 1 : -1;
                for (int k = 0; k < m + n; k++) {
                    if (k - diff >= 0 && k - diff < m + n && (dp[i - 1][j][k - diff] || dp[i][j - 1][k - diff])) {
                        dp[i][j][k] = true;
                    }
                }
            }
        }
        return dp[m - 1][n - 1][delta];
    }
}

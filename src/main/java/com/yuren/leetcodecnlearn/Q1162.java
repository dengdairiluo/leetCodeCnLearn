package com.yuren.leetcodecnlearn;

import java.util.Arrays;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-11-21 23:50
 */
public class Q1162 {
    public int maxDistance(int[][] grid) {
        int n = grid.length, ans = -1, max = Integer.MAX_VALUE / 2;
        int[][] dp = new int[n + 2][n + 2];
        for (int i = 0; i < n + 2; i++) {
            Arrays.fill(dp[i], max);
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = grid[i - 1][j - 1] == 0 ? Math.min(dp[i - 1][j], dp[i][j - 1]) + 1 : 0;
            }
        }
        for (int i = n; i > 0; i--) {
            for (int j = n; j > 0; j--) {
                if (grid[i - 1][j - 1] == 0) {
                    dp[i][j] = Math.min(dp[i][j], Math.min(dp[i + 1][j], dp[i][j + 1]) + 1);
                    ans = Math.max(ans, dp[i][j]);
                }
            }
        }
        return ans > 0 && ans < max ? ans : -1;
    }
}

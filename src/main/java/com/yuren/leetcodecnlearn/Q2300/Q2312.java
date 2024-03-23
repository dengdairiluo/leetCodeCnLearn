package com.yuren.leetcodecnlearn.Q2300;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-03-24 01:53
 */
public class Q2312 {
    public long sellingWood(int m, int n, int[][] prices) {
        long[][] dp = new long[m + 1][n + 1];
        int[][] price = new int[m + 1][n + 1];
        for (int[] arr : prices) {
            price[arr[0]][arr[1]] = arr[2];
        }
        dp[1][1] = price[1][1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                long max = price[i][j];
                for (int k = 1; k <= (i >> 1); k++) {
                    max = Math.max(max, dp[k][j] + dp[i - k][j]);
                }
                for (int k = 1; k <= (j >> 1); k++) {
                    max = Math.max(max, dp[i][k] + dp[i][j - k]);
                }
                dp[i][j] = max;
            }
        }
        return dp[m][n];
    }
}

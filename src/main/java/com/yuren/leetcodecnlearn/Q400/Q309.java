package com.yuren.leetcodecnlearn.Q400;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2021-11-20 20:26
 */
public class Q309 {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n <= 1) {
            return 0;
        }

        int[][] dp = new int[n][3];
        dp[0][0] = 0;
        dp[0][1] = -1 * prices[0];
        dp[0][2] = 0;

        //从[1]...[n-1]
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
            dp[i][2] = dp[i - 1][1] + prices[i];

        }
        return Math.max(dp[n - 1][0], dp[n - 1][2]);


    }

}

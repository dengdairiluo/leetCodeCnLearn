package com.yuren.leetcodecnlearn.Q2400;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-05-22 下午11:52
 */
public class Q2431 {
    public int maxTastiness(int[] price, int[] tastiness, int maxAmount, int maxCoupons) {
        //dp[i + 1][j][k] = max: dp[i][j][k], dp[i][j - x][k] + t, dp[i][j - x / 2][k - 1] + t;
        int n = price.length;
        int[][] dp = new int[maxAmount + 1][maxCoupons + 1];
        for (int i = 0; i < n; i++) {//tastiness
            int t = tastiness[i], x = price[i];
            for (int j = maxAmount; j >= x / 2; j--) {
                for (int k = maxCoupons; k >= 0; k--) {
                    if (j >= x && k > 0)
                        dp[j][k] = Math.max(dp[j][k], Math.max(dp[j - x][k], dp[j - x / 2][k - 1]) + t);
                    else if (k > 0) dp[j][k] = Math.max(dp[j][k], dp[j - x / 2][k - 1] + t);
                    else if (j >= x) dp[j][k] = Math.max(dp[j][k], dp[j - x][k] + t);
                }
            }
        }

        return dp[maxAmount][maxCoupons];
    }
}

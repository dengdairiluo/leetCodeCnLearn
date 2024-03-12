package com.yuren.leetcodecnlearn.Q2200;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-03-12 23:09
 */
public class Q2291 {
    public int maximumProfit(int[] present, int[] future, int budget) {
        int[] dp = new int[budget + 1];
        int n = present.length;
        for (int i = 0; i < n; i++) {
            for (int j = budget; j >= present[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - present[i]] + future[i] - present[i]);
            }
        }

        int ans = 0;
        for (int i = 0; i <= budget; i++) {
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }

}

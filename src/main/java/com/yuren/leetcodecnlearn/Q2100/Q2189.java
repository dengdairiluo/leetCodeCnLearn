package com.yuren.leetcodecnlearn.Q2100;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-01-21 23:53
 */
public class Q2189 {
    public int houseOfCards(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int num = 2; num <= n; num += 3) {
            for (int j = n; j >= num; j--) {
                dp[j] += dp[j - num];
            }
        }
        return dp[n];
    }
}

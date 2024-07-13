package com.yuren.leetcodecnlearn.Q2500;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-07-13 下午11:26
 */
public class Q2533 {
    public int goodBinaryStrings(int minLength, int maxLength, int oneGroup, int zeroGroup) {
        int MOD = 1000000007;
        int[] dp = new int[maxLength + 1];
        dp[0] = 1;
        int ans = 0;
        for (int i = 1; i <= maxLength; i++) {
            if (i - oneGroup >= 0) dp[i] = (dp[i] + dp[i - oneGroup]) % MOD;
            if (i - zeroGroup >= 0) dp[i] = (dp[i] + dp[i - zeroGroup]) % MOD;
            if (i >= minLength) ans = (ans + dp[i]) % MOD;
        }
        return ans;
    }
}

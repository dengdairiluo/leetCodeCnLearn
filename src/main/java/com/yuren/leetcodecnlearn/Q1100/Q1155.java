package com.yuren.leetcodecnlearn.Q1100;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-11-17 23:55
 */
public class Q1155 {
    public int numRollsToTarget(int n, int k, int target) {
        if (target < n || target > n * k) return 0;
        long mod = 1000000007;
        long[] dp = new long[target + 1];
        long[] tmp = new long[target + 1];
        for (int i = 1; i <= k && i <= target; i++) dp[i] = 1;

        for (int t = 1; t++ < n; ) {
            tmp[t] = 1;
            for (int i = t + 1, m = k * t; i <= m && i <= target; i++) {
                tmp[i] = tmp[i - 1] + dp[i - 1];
                if (i - k > 1)
                    for (; i <= m && i <= target; i++) tmp[i] = tmp[i - 1] + dp[i - 1] - dp[i - k - 1];
            }

            for (int i = t - 1, m = k * t; i <= m && i <= target; i++) {
                dp[i] = tmp[i] % mod;
                tmp[i] = 0;
            }
        }
        int ans = (int) dp[target];
        return ans;
    }
}

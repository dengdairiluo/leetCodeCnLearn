package com.yuren.leetcodecnlearn;

import java.util.Arrays;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-08-09 23:52
 */
public class Q920 {
    public int numMusicPlaylists(int n, int goal, int k) {
        int mod = 1_000_000_007;

        // dp[S] at time P = <S, P> as discussed in article
        long[] dp = new long[goal - n + 1];
        Arrays.fill(dp, 1);
        for (int p = 2; p <= n - k; ++p) {
            for (int i = 1; i <= goal - n; ++i) {
                dp[i] += dp[i - 1] * p;
                dp[i] %= mod;
            }
        }

        // Multiply by N!
        long ans = dp[goal - n];
        for (int i = 2; i <= n; ++i) {
            ans = ans * i % mod;
        }
        return (int) ans;
    }
}

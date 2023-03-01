package com.yuren.leetcodecnlearn.Q1500;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-03-01 23:32
 */
public class Q1420 {
    private final static int MOD = 1_000_000_007;

    public int numOfArrays(int n, int m, int k) {
        int[][] dp = new int[m + 1][k + 1];
        int pos = 1;
        for (int i = 1; i <= m; i++) {
            dp[i][1] = 1;
        }
        while (pos < n) {
            pos++;
            int[][] dp2 = new int[m + 1][k + 1];
            for (int i = 1; i <= Math.min(k, pos); i++) {
                int sum = 0;
                for (int j = 1; j <= m; j++) {
                    sum += dp[j - 1][i - 1];
                    sum %= MOD;
                    long tmp = (long) j * dp[j][i] + sum;
                    dp2[j][i] = (int) (tmp % MOD);
                }
            }
            dp = dp2;
        }
        int ans = 0;
        for (int i = 1; i <= m; i++) {
            ans += dp[i][k];
            ans %= MOD;
        }
        return ans;
    }
}

package com.yuren.leetcodecnlearn.Q1300;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-01-09 23:58
 */
public class Q1269 {
    private static final int MOD = 1000000007;

    public int numWays(int steps, int arrLen) {
        int maxColumn = Math.min(arrLen - 1, steps);
        int[] dp = new int[maxColumn + 1];
        dp[0] = 1;
        for (int i = 1; i <= steps; i++) {
            int[] dpNext = new int[maxColumn + 1];
            for (int j = 0; j <= maxColumn; j++) {
                dpNext[j] = dp[j];
                if (j - 1 >= 0) {
                    dpNext[j] = (dpNext[j] + dp[j - 1]) % MOD;
                }
                if (j + 1 <= maxColumn) {
                    dpNext[j] = (dpNext[j] + dp[j + 1]) % MOD;
                }
            }
            dp = dpNext;
        }
        return dp[0];
    }
}

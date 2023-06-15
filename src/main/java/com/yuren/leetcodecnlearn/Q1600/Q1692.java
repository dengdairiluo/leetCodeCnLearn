package com.yuren.leetcodecnlearn.Q1600;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-06-15 23:33
 */
public class Q1692 {
    private static final int mod = (int) 1e9 + 7;
    static int[][] dp = new int[1000 + 1][1000 + 1];
    static boolean isLoaded = false;

    public int waysToDistribute(int n, int k) {
        if (!isLoaded) {
            dp[0][0] = 1;

            for (int i = 1; i <= 1000; ++i) {
                for (int j = 1; j <= 1000; ++j) {
                    dp[i][j] = (int) (((long) dp[i - 1][j] * j + dp[i - 1][j - 1]) % mod);
                }
            }
            isLoaded = true;
        }
        return dp[n][k];
    }
}

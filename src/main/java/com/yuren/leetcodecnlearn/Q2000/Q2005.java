package com.yuren.leetcodecnlearn.Q2000;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-10-23 23:15
 */
public class Q2005 {
    public boolean findGameWinner(int n) {
        if (n == 1) return false;
        int[] dp = new int[n];
        for (int i = 1; i < n; i++) {
            if (i == 1) {
                dp[i] = 1;
            } else {
                dp[i] = 1 + (dp[i - 1] ^ dp[i - 2]);
            }
        }
        return (dp[n - 1] ^ dp[n - 2]) != 0;
    }
}

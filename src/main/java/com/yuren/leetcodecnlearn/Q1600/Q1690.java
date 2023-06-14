package com.yuren.leetcodecnlearn.Q1600;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-06-14 23:47
 */
public class Q1690 {
    public static int[] dp = new int[1000];

    public int stoneGameVII(int[] stones) {
        int n = stones.length;
        boolean even = n % 2 == 0;
        for (int i = 0; i < n; i++) {
            dp[i] = even ? stones[i] : 0;
        }
        for (int len = 2; len <= n; len++) {
            for (int i = 0, j = len - 1; i <= n - len; i++, j++) {
                dp[i] = even ? Math.max(dp[i + 1], dp[i]) : Math.min(dp[i + 1] + stones[i], dp[i] + stones[j]);
            }
            even = !even;
        }
        return dp[0];
    }
}

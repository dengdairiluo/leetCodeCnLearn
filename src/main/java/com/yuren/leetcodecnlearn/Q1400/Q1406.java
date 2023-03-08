package com.yuren.leetcodecnlearn.Q1400;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-02-25 23:29
 */
public class Q1406 {
    public String stoneGameIII(int[] stoneValue) {
        int n = stoneValue.length;
        int[] dp = new int[n + 1];
        int sum = stoneValue[n - 1];
        dp[n - 1] = sum;
        if (n - 2 >= 0) {
            sum += stoneValue[n - 2];
            dp[n - 2] = sum - Math.min(dp[n - 1], dp[n]);
        }
        for (int i = n - 3; i >= 0; i--) {
            sum += stoneValue[i];
            dp[i] = sum - Math.min(dp[i + 1], Math.min(dp[i + 2], dp[i + 3]));
        }
        if (dp[0] * 2 > sum) {
            return "Alice";
        } else if (dp[0] * 2 < sum) {
            return "Bob";
        } else {
            return "Tie";
        }
    }
}

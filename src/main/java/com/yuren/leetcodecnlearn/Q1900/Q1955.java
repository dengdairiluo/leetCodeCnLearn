package com.yuren.leetcodecnlearn.Q1900;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-09-27 06:04
 */
public class Q1955 {
    private static final int MOD = 1_000_000_007;

    public int countSpecialSubsequences(int[] nums) {
        int n = nums.length;
        long[] dp = new long[3];
        dp[0] = nums[0] == 0 ? 1 : 0;
        for (int i = 1; i < n; i++) {
            int num = nums[i];
            if (num == 0) {
                dp[0] = (2 * dp[0] + 1) % MOD;
            } else {
                dp[num] = (2 * dp[num] + dp[num - 1]) % MOD;
            }
        }
        return (int) dp[2];
    }
}

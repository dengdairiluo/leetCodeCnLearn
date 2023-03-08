package com.yuren.leetcodecnlearn.Q1200;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-01-08 23:25
 */
public class Q1259 {
    public int numberOfWays(int numPeople) {
        if (numPeople == 2) {
            return 1;
        }
        int mod = (int) (Math.pow(10, 9) + 7);
        // dp[i] 表示 i 个人的不会相交的握手方案数
        long[] dp = new long[numPeople + 1];
        // 一个人或者没有人无法握手
        dp[0] = dp[1] = 0;
        // 两个人只有一种握手
        dp[2] = 1;
        for (int i = 3; i <= numPeople; i++) {
            long sum = 0;
            for (int k = 4; k <= i - 2; k += 2) {
                sum += (dp[k - 2] * dp[i - k]) % mod;
            }
            dp[i] = (2 * dp[i - 2] % mod + sum) % mod;
        }
        return (int) (dp[numPeople] % mod);
    }
}

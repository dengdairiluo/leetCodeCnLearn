package com.yuren.leetcodecnlearn;

import java.util.stream.LongStream;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-03-03 23:39
 */
public class Q552 {
    int MOD = 1000000007;

    public int checkRecord(int n) {
        long[][] dp = new long[2][6];
        // 初始值
        dp[0][0] = 1;
        dp[0][1] = 1;
        dp[0][3] = 1;

        for (int i = 1; i < n; i++) {
            // 当前使用的下标
            int cur = i & 1;
            // 上一次使用的下标
            int last = (i - 1) & 1;
            dp[cur][0] = (dp[last][0] + dp[last][1] + dp[last][2]) % MOD;
            dp[cur][1] = dp[last][0];
            dp[cur][2] = dp[last][1];
            dp[cur][3] = (dp[last][3] + dp[last][4] + dp[last][5] + dp[last][0] + dp[last][1] + dp[last][2]) % MOD;
            dp[cur][4] = dp[last][3];
            dp[cur][5] = dp[last][4];
        }

        return (int) (LongStream.of(dp[(n - 1) & 1]).sum() % MOD);
    }
}

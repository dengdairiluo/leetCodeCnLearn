package com.yuren.leetcodecnlearn.Q2300;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-03-31 21:48
 */
public class Q2327 {
    private static final int MOD = (int) 1e9 + 7;

    public int peopleAwareOfSecret(int n, int delay, int forget) {
        //dp[i] 表示第 i 天新增了多少人
        long newCreate = 1;

        //创建前缀和数组
        long[] sum = new long[n + 1];
        sum[1] = 1;

        for (int i = 2; i < n + 1; i++) {
            //可以用前缀和简化代码
            // dp[i] = sum[i - forget + 1, i - delay]

            //因为边界可能小于 0，故单独判断
            if (i - delay < 0) {
                newCreate = 0;
            } else if (i - forget < 0) {
                newCreate = (sum[i - delay] - sum[0] + MOD) % MOD;
            } else {
                newCreate = (sum[i - delay] - sum[i - forget] + MOD) % MOD;
            }
            sum[i] = (sum[i - 1] + newCreate) % MOD;
        }

        //第 n 天还剩余的人数，为最后几天新增的人数之和
        return (int) ((sum[n] - sum[n - forget]) + MOD) % MOD;
    }
}

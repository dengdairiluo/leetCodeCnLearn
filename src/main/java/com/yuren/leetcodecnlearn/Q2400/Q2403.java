package com.yuren.leetcodecnlearn.Q2400;

import java.util.Arrays;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-05-09 下午11:11
 */
public class Q2403 {
    public long minimumTime(int[] power) {
        // 状态压缩动态规划。
        int n = power.length;
        int mask = 1 << n;
        // 定义动态规划数组，dp[mask] 表示打编码为 mask 的怪兽需要的时间。
        long[] dp = new long[mask];
        Arrays.fill(dp, Long.MAX_VALUE);
        // 不打怪不需要时间。
        dp[0] = 0L;
        // 枚举所有的编码情况。
        for (int i = 0; i < mask; i++) {
            // 枚举一个编码中的 1，通过 i - (1 << j) 来状态转移。
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    // 每一次打怪以后法力值都会归零，而打怪结束以后的增长速度就是状态编码中 1 的
                    // 个数加上 1（也就是编码 i 的 1 的个数），可以直接计算出需要等待的时间。
                    // bits 代表 i - (1 << j) 的 1 的个数，也是此时的法力值增长速度。
                    int bits = Integer.bitCount(i);
                    // 需要的时间是 dp[i ^ (1 << j)] + power[j] / bits(向上取整)。保留最小时间。
                    dp[i] = Math.min(dp[i ^ (1 << j)] + (power[j] + bits - 1) / bits, dp[i]);
                }
            }
        }
        // 击败所有怪的时间就是答案。
        return dp[mask - 1];
    }
}

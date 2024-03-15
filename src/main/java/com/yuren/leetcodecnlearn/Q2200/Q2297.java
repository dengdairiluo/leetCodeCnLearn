package com.yuren.leetcodecnlearn.Q2200;

import java.util.Arrays;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-03-15 23:58
 */
public class Q2297 {
    public long minCost(int[] nums, int[] costs) {

        int n = nums.length;
        long[] dp = new long[n];
        Arrays.fill(dp, Long.MAX_VALUE);
        dp[0] = 0;

        int[] minStack = new int[n];
        int[] maxStack = new int[n];
        int top1 = -1;
        int top2 = -1;

        for (int j = 0; j < n; ++j) {

            while (top1 != -1 && nums[minStack[top1]] <= nums[j]) {
                dp[j] = Math.min(dp[j], dp[minStack[top1--]] + costs[j]);
            }
            minStack[++top1] = j;

            while (top2 != -1 && nums[maxStack[top2]] > nums[j]) {
                dp[j] = Math.min(dp[j], dp[maxStack[top2--]] + costs[j]);
            }
            maxStack[++top2] = j;
        }

        return dp[n - 1];

    }
}

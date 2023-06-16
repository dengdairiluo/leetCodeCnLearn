package com.yuren.leetcodecnlearn.Q1600;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-06-16 23:54
 */
public class Q1696 {
    public int maxResult(int[] nums, int k) {
        if (nums.length == 1) {
            return nums[0];
        }
        int length = nums.length;
        // dp[i] = 到达i位置可得的最大分数
        int[] dp = new int[length];
        // 初始化除0外的所有值为最小
        dp[0] = nums[0];
        for (int i = 1; i < length; i++) {
            dp[i] = Integer.MIN_VALUE;
        }
        for (int i = 0; i < length; i++) {
            // dp[i]可到达的所有位置
            for (int j = i + 1; j < length && j <= i + k; j++) {
                // 从i跳跃到j位置, j位置的最大得分
                int nextNum = dp[i] + nums[j];
                // 如果比j位置当前最大得分大, 则更新j位置最大得分
                if (dp[j] < nextNum) {
                    dp[j] = nextNum;
                }
                // 剪枝, i后面能影响到的分数, 可以由遍历到j时进行更新
                if (dp[j] >= dp[i]) {
                    break;
                }
            }
        }
        return dp[length - 1];
    }
}

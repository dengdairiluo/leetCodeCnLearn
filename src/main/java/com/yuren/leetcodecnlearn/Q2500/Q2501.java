package com.yuren.leetcodecnlearn.Q2500;

import java.util.Arrays;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-06-26 下午11:56
 */
public class Q2501 {
    public int longestSquareStreak(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length, max = nums[n - 1], len = -1;
        int[] dp = new int[max + 1];
        for (int num : nums) {
            dp[num] = 1;
        }
        for (int num : nums) {
            int x = (int) Math.sqrt(num);
            if (x * x != num) continue;
            dp[num] = dp[x] + 1;
        }
        for (int i = 0; i <= max; i++) {
            if (dp[i] >= 2) len = Math.max(len, dp[i]);
        }
        return len;
    }
}

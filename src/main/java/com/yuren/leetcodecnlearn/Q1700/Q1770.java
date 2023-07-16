package com.yuren.leetcodecnlearn.Q1700;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-07-16 23:22
 */
public class Q1770 {
    public int maximumScore(int[] nums, int[] mult) {
        int n = nums.length, m = mult.length;
        int[][] dp = new int[m + 1][m + 1];
        // 计算只从左边取或者只从右边取的情况，避免后面的越界判断
        for (int i = 1; i <= m; i++) {
            dp[0][i] = dp[0][i - 1] + nums[n - i] * mult[i - 1];
            dp[i][0] = dp[i - 1][0] + nums[i - 1] * mult[i - 1];
        }

        // 状态计算
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= m - i; j++) {
                int idx = i + j - 1;
                dp[i][j] = Math.max(dp[i - 1][j] + nums[i - 1] * mult[idx], dp[i][j - 1] + nums[n - j] * mult[idx]);
            }
        }

        // 获取最终结果
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i <= m; i++) {
            ans = Math.max(ans, dp[i][m - i]);
        }

        return ans;
    }
}

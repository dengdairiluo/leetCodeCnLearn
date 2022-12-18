package com.yuren.leetcodecnlearn.Q1100;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-09-24 22:52
 */
public class Q1027 {
    public int longestArithSeqLength(int[] nums) {

        int n = nums.length;
        int[][] dp = new int[n][1001];
        //保存结果
        int maxLen = 0;
        for (int k = 1; k < n; k++) {
            for (int j = 0; j < k; j++) {
                //统一加偏移量，使下标非负
                int d = nums[k] - nums[j] + 500;
                //根据 d 去填充dp[k][d]
                dp[k][d] = dp[j][d] + 1;
                //维护最大值
                maxLen = Math.max(maxLen, dp[k][d]);
            }
        }
        return maxLen + 1;
    }
}

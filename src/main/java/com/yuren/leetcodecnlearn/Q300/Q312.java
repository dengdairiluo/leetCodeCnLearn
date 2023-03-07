package com.yuren.leetcodecnlearn.Q300;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2021-11-20 20:45
 */
public class Q312 {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = nums[i] * this.lr(nums, i - 1, i + 1);
        }
        for (int l = n - 1; l >= 0; l--) {
            for (int r = l + 1; r < n; r++) {
                int lr = this.lr(nums, l - 1, r + 1);
                //戳左边
                int max = dp[l + 1][r] + nums[l] * lr;
                //戳右边
                max = Math.max(max, dp[l][r - 1] + nums[r] * lr);
                for (int i = l + 1; i < r; i++) {
                    //戳中间
                    max = Math.max(max, dp[l][i - 1] + dp[i + 1][r] + nums[i] * lr);
                }
                dp[l][r] = max;
            }
        }
        // 0..n-1 范围上戳爆气球最大
        return dp[0][n - 1];
    }

    private int lr(int[] nums, int l, int r) {
        int lNum = l == -1 ? 1 : nums[l];
        int rNum = r == nums.length ? 1 : nums[r];
        return lNum * rNum;
    }
}

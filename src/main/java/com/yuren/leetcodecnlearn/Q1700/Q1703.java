package com.yuren.leetcodecnlearn.Q1700;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-06-19 23:34
 */
public class Q1703 {
    public int minMoves(int[] nums, int k) {
        int n = nums.length, m = 0;
        for (int i = 0; i < n; ++i) {
            if (nums[i] != 0) {
                nums[m] = i - m;
                ++m;
            }
        }
        if (m == n) {
            // 全部都是 1
            return 0;
        }
        int[] p = nums;
        // s[i] s[i+k/2] s[i+k]
        int sl = 0, sm = 0, sr = 0;
        for (int i = 0; i < k; ++i) {
            if (i < k / 2) {
                sm += p[i];
            }
            sr += p[i];
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i <= m - k; ++i) {
            ans = Math.min(ans, sl + sr - sm * 2 - p[i + k / 2] * (k % 2));
            sl += p[i];
            sm += p[i + k / 2];
            sr += p[i + k];
        }
        return ans;
    }
}

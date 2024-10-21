package com.yuren.leetcodecnlearn.Q2700;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author 10204
 * @date 2024-10-21 23:40
 */
public class Q2735 {
    public long minCost(int[] nums, int x) {
        int n = nums.length;
        // s[k] 统计操作 k 次的总成本
        long[] s = new long[n];
        for (int i = 0; i < n; i++) {
            s[i] = (long) i * x;
        }
        // 子数组左端点
        for (int i = 0; i < n; i++) {
            int mn = nums[i];
            // 子数组右端点（把数组视作环形的）
            for (int j = i; j < n + i; j++) {
                // 维护从 nums[i] 到 nums[j] 的最小值
                mn = Math.min(mn, nums[j % n]);
                // 累加操作 j-i 次的花费
                s[j - i] += mn;
            }
        }
        long ans = Long.MAX_VALUE;
        for (long v : s) {
            ans = Math.min(ans, v);
        }
        return ans;
    }
}

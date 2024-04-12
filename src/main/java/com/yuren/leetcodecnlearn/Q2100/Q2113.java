package com.yuren.leetcodecnlearn.Q2100;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-12-14 22:51
 */
public class Q2113 {
    public int[] elementInNums(int[] nums, int[][] queries) {
        int len = nums.length, n = queries.length;
        int[] res = new int[n];
        // 周期
        int T = 2 * len;
        for (int i = 0; i < n; i++) {
            // 当前时间
            int t = queries[i][0] % T;
            // 前一半
            if (t < len) {
                // 下标转换
                int idx = queries[i][1] + t;
                res[i] = idx >= len ? -1 : nums[idx];
                // 后一半
            } else {
                int idx = queries[i][1];
                res[i] = idx >= (t - len) ? -1 : nums[idx];
            }
        }
        return res;
    }
}

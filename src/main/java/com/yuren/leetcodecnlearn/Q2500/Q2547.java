package com.yuren.leetcodecnlearn.Q2500;

import java.util.Arrays;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-07-19 下午11:52
 */
public class Q2547 {
    public int minCost(int[] nums, int k) {
        int n = nums.length;
        int[] f = new int[n + 1];
        byte[] state = new byte[n];
        for (int i = 0; i < n; ++i) {
            Arrays.fill(state, (byte) 0);
            int unique = 0, mn = Integer.MAX_VALUE;
            for (int j = i; j >= 0; --j) {
                int x = nums[j];
                if (state[x] == 0) { // 首次出现
                    state[x] = 1;
                    ++unique;
                } else if (state[x] == 1) { // 不再唯一
                    state[x] = 2;
                    --unique;
                }
                mn = Math.min(mn, f[j] - unique);
            }
            f[i + 1] = k + mn;
        }
        return f[n] + n;
    }
}

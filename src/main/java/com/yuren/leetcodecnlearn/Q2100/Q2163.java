package com.yuren.leetcodecnlearn.Q2100;

import java.util.PriorityQueue;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-01-08 22:48
 */
public class Q2163 {
    public long minimumDifference(int[] nums) {
        PriorityQueue<Integer> left = new PriorityQueue<>((a, b) -> b - a);
        PriorityQueue<Integer> right = new PriorityQueue<>();
        int n = nums.length / 3;
        long[] f = new long[n + 1];
        long[] g = new long[n + 1];
        long ls = 0, rs = 0;
        for (int i = 0; i < n; i++) {
            left.add(nums[i]);
            ls += nums[i];
        }
        f[0] = ls;
        for (int i = n; i < 2 * n; i++) {
            int cur_max = left.peek();
            if (cur_max > nums[i]) {
                left.poll();
                left.add(nums[i]);
                ls = ls - cur_max + nums[i];
            }
            f[i - n + 1] = ls;
        }

        for (int i = 3 * n - 1; i >= 2 * n; i--) {
            right.add(nums[i]);
            rs += nums[i];
        }
        g[n] = rs;

        for (int i = 2 * n - 1; i >= n; i--) {
            int cur_min = right.peek();
            if (cur_min < nums[i]) {
                right.poll();
                right.add(nums[i]);
                rs = rs - cur_min + nums[i];
            }
            g[i - n] = rs;
        }

        long ans = Long.MAX_VALUE;
        for (int i = 0; i <= n; i++) {
            ans = Math.min(ans, f[i] - g[i]);
        }
        return ans;
    }
}

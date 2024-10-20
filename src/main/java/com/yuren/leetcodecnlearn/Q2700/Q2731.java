package com.yuren.leetcodecnlearn.Q2700;

import java.util.Arrays;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author 10204
 * @date 2024-10-19 20:08
 */
public class Q2731 {
    public int sumDistance(int[] nums, String s, int d) {
        final long MOD = (long) 1e9 + 7;
        int n = nums.length;
        long[] a = new long[n]; // 用 long 是因为 nums[i]+d 可能是 2e9+1e9，溢出了
        for (int i = 0; i < n; i++) {
            a[i] = (long) nums[i] + (s.charAt(i) == 'L' ? -d : d);
        }
        Arrays.sort(a);

        long ans = 0, sum = 0;
        for (int i = 0; i < n; i++) {
            ans = (ans + i * a[i] - sum) % MOD;
            sum += a[i];
        }
        return (int) ans;
    }
}

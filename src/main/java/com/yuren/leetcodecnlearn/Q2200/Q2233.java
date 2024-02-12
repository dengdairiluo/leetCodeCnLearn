package com.yuren.leetcodecnlearn.Q2200;

import java.util.Arrays;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-02-12 21:34
 */
public class Q2233 {
    private static final long MOD = (long) 1e9 + 7;

    public int maximumProduct(int[] nums, int k) {
        long ans = 1;
        long x, y;
        Arrays.sort(nums);
        int n = nums.length;
        long pre = 0;
        long dif = 0;
        for (int i = 0; i < n; i++) {
            dif = (long) nums[i] * i - pre;
            pre += (long) nums[i];
            if (dif < k && i != n - 1 && (k - dif) / (i + 1) >= nums[i + 1] - nums[i]) {
                continue;
            } else {
                // if (i == n - 1) {
                //     long sum = pre + k;
                //     x = sum / n;
                //     y = sum % n;
                //     ans = (ans * f(x + 1, y) % MOD);
                //     ans = (ans * f(x, n - y) % MOD);
                //     return (int)ans;
                // }
                // sum = pre + k - (k - dif);
                long sum = pre + k;
                x = sum / (i + 1);
                y = sum % (i + 1);
                ans = (ans * f(x + 1, y) % MOD);
                ans = (ans * f(x, i + 1 - y) % MOD);
                for (int j = i + 1; j < n; j++) {
                    ans = (ans * nums[j]) % MOD;
                }
                return (int) ans;
            }
        }
        return (int) ans;
    }

    public long f(long x, long y) {
        long res = 1;
        while (y > 0) {
            if ((y & 1) == 1) {
                res = (res * x) % MOD;
            }
            x = (x * x) % MOD;
            y >>= 1;
        }
        return res;
    }
}

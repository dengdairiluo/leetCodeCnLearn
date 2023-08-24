package com.yuren.leetcodecnlearn.Q1800;

import java.util.Arrays;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-08-24 23:36
 */
public class Q1879 {
    public int minimumXORSum(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int u = 1 << n;
        int[] dp = new int[u];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int mask = 0; mask < u; mask++) {
            // 匹配到第k个
            int k = Integer.bitCount(mask);
            // for (int i = 0; i < n; i++) {
            //     if ((mask >> i & 1) == 0) {
            //         dp[mask | 1 << i] = Math.min(dp[mask | 1 << i], dp[mask] + (nums1[k] ^ nums2[i]));
            //     }
            // }
            for (int t = mask ^ u - 1, lb = 0; t > 0; t ^= lb) {
                // System.out.println(t);
                lb = t & (-t);
                int k2 = Integer.numberOfTrailingZeros(lb);
                // System.out.println(lb);
                // System.out.println(mask | lb);
                dp[mask | lb] = Math.min(dp[mask | lb], dp[mask] + (nums1[k] ^ nums2[k2]));
            }
        }
        return dp[u - 1];
    }
}

package com.yuren.leetcodecnlearn;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-06-27 23:16
 */
public class Q823 {
    public int numFactoredBinaryTrees(int[] A) {
        int mod = 1_000_000_007;
        int n = A.length;
        Arrays.sort(A);
        long[] dp = new long[n];
        Arrays.fill(dp, 1);

        Map<Integer, Integer> index = new HashMap<>();
        for (int i = 0; i < n; ++i) {
            index.put(A[i], i);
        }

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < i; ++j) {
                // A[j] is left child
                if (A[i] % A[j] == 0) {
                    int right = A[i] / A[j];
                    if (index.containsKey(right)) {
                        dp[i] = (dp[i] + dp[j] * dp[index.get(right)]) % mod;
                    }
                }
            }
        }

        long ans = 0;
        for (long x : dp) ans += x;
        return (int) (ans % mod);
    }
}

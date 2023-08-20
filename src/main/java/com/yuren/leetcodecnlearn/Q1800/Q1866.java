package com.yuren.leetcodecnlearn.Q1800;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-08-20 20:24
 */
public class Q1866 {

    private static final int MOD = 1000_000_007;

    public int rearrangeSticks(int n, int k) {
        if (n == k) {
            return 1;
        }
        int[] counts = new int[k + 1];
        counts[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = Math.min(i, k); j > 0; j--) {
                counts[j] = (int) ((counts[j - 1] + (long) (i - 1) * counts[j]) % MOD);
            }
            counts[0] = 0;
        }
        return counts[k];
    }
}

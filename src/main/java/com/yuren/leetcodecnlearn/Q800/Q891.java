package com.yuren.leetcodecnlearn.Q800;

import java.util.Arrays;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-07-28 21:21
 */
public class Q891 {
    private static final int MOD = (int) (1e9 + 7);
    public int sumSubseqWidths(int[] a) {
        Arrays.sort(a);
        int n = a.length;
        long res = 0;
        long p = 1;
        for (int i = 0; i < n; ++i) {
            res = (res + (a[i] - a[n - 1 - i]) * p) % MOD;
            p = (p << 1) % MOD;
        }
        return (int) ((res + MOD) % MOD);
    }
}

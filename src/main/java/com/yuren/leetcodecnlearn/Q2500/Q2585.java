package com.yuren.leetcodecnlearn.Q2500;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-08-07 下午11:48
 */
public class Q2585 {
    private static final int MOD = (int) 1e9 + 7;

    public int waysToReachTarget(int target, int[][] types) {
        int[] f = new int[target + 1];
        f[0] = 1;
        for (int[] p : types) {
            int count = p[0], marks = p[1];
            for (int j = target; j > 0; --j)
                for (int k = 1; k <= count && k <= j / marks; ++k)
                    f[j] = (f[j] + f[j - k * marks]) % MOD;
        }
        return f[target];
    }
}

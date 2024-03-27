package com.yuren.leetcodecnlearn.Q2300;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-03-27 23:48
 */
public class Q2320 {
    static int[] f = new int[10001];
    static int MOD = 1000000007;

    public int getValue(int n) {
        // 说明计算过
        if (f[n] > 0) return f[n];
        f[0] = 1;
        f[1] = 2;
        for (int i = 2; i < 10001; i++) {
            f[i] = (f[i - 2] + f[i - 1]) % MOD;
        }
        return f[n];
    }

    public int countHousePlacements(int n) {
        long v = (long) getValue(n);
        return (int) ((long) f[n] * f[n] % MOD);
    }
}

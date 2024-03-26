package com.yuren.leetcodecnlearn.Q2300;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-03-26 22:14
 */
public class Q2318 {
    static final int MOD = (int) 1e9 + 7, MX = (int) 1e4;
    static final int[][] f = new int[MX + 1][6];

    static {
        for (int i = 0; i < 6; ++i)
            f[1][i] = 1;
        for (int i = 2; i <= MX; ++i)
            for (int j = 0; j < 6; ++j) {
                double s = 0L;
                for (int k = 0; k < 6; ++k)
                    if (k != j && gcd(k + 1, j + 1) == 1)
                        s += f[i - 1][k];
                s -= (long) (i > 3 ? f[2][j] - 1 : f[2][j]) * f[i - 2][j];
                f[i][j] = (int) (s % MOD);
            }
    }

    public int distinctSequences(int n) {
        double ans = 0L;
        for (int v : f[n])
            ans += v;
        return (int) (ans % MOD + MOD) % MOD; // 保证结果非负
    }

    static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}

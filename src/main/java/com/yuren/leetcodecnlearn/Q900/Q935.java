package com.yuren.leetcodecnlearn.Q900;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-08-15 23:41
 */
public class Q935 {
    private static final int MOD = 1_000_000_007;

    public int knightDialer(int n) {
        long[][] mat = new long[][]{{0, 0, 0, 0, 1, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 1, 0, 1, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 0, 1},
                {0, 0, 0, 0, 1, 0, 0, 0, 1, 0},
                {1, 0, 0, 1, 0, 0, 0, 0, 0, 1},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {1, 1, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 1, 0, 0, 0, 1, 0, 0, 0},
                {0, 1, 0, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, 0, 1, 0, 0, 0, 0, 0}};
        long[][] res = pow(mat, n - 1);
        long ans = 0;
        for (int i = 0; i < 10; i++) {
            ans += res[i][0];
        }
        return (int) (ans % MOD);
    }

    private long[][] pow(long[][] mat, int n) {
        long[][] res = new long[10][1];
        for (int i = 0; i < 10; i++) {
            res[i][0] = 1;
        }
        while (n > 0) {
            if ((n & 1) == 1) {
                res = mul(mat, res);
            }
            mat = mul(mat, mat);
            n >>= 1;
        }

        return res;
    }

    private long[][] mul(long[][] a, long[][] b) {
        int r = a.length;
        int c = b[0].length;
        int n = a[0].length;
        long[][] res = new long[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                for (int k = 0; k < n; k++) {
                    res[i][j] += (a[i][k] * b[k][j]);
                    res[i][j] %= MOD;
                }
            }
        }
        return res;
    }
}

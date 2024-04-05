package com.yuren.leetcodecnlearn.Q2300;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-04-05 下午9:56
 */
public class Q2338 {
    // 至多 13 个质因数
    static final int MOD = (int) 1e9 + 7, MX = (int) 1e4 + 1, MX_K = 13;
    static List[] ks = new List[MX]; // ks[x] 为 x 分解质因数后，每个质因数的个数列表
    // 组合数
    static int[][] c = new int[MX + MX_K][MX_K + 1];

    static {
        for (int i = 1; i < MX; i++) {
            ks[i] = new ArrayList<Integer>();
            int x = i;
            for (int p = 2; p * p <= x; ++p) {
                if (x % p == 0) {
                    int k = 1;
                    for (x /= p; x % p == 0; x /= p) ++k;
                    ks[i].add(k);
                }
            }
            if (x > 1) ks[i].add(1);
        }

        c[0][0] = 1;
        for (int i = 1; i < MX + MX_K; ++i) {
            c[i][0] = 1;
            for (int j = 1; j <= Math.min(i, MX_K); ++j)
                c[i][j] = (c[i - 1][j] + c[i - 1][j - 1]) % MOD;
        }
    }

    public int idealArrays(int n, int maxValue) {
        long ans = 0L;
        for (int x = 1; x <= maxValue; ++x) {
            double mul = 1L;
            for (Object k : ks[x]) mul = mul * c[n + (int) k - 1][(int) k] % MOD;
            ans += mul;
        }
        return (int) (ans % MOD);
    }
}

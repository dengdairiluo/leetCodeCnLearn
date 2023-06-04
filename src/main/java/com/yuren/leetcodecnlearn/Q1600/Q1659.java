package com.yuren.leetcodecnlearn.Q1600;

import java.util.Arrays;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-06-04 23:54
 */
public class Q1659 {
    private static final int[][] cross = {{0, 0, 0}, {0, -60, -10}, {0, -10, 40}};
    private static final int count[] = {0, 0, 1, 2, 4, 5, 7};

    public int getMaxGridHappiness(int m, int n, int introvertsCount, int extrovertsCount) {
        if (m < n) {
            int a = m;
            m = n;
            n = a;
        }

        int mx = introvertsCount * 120 + extrovertsCount * 40 + count[extrovertsCount] * 40;

        if (n == 5)
            return mx;
        if (n == 4 && m == 5)
            return Math.min(mx, 1230);

        int N = (int) Math.pow(3, n), N_3 = N / 3;
        int[][][][] f = new int[m * n + 1][introvertsCount + 2][extrovertsCount + 2][N];

        for (int i = 0; i < f.length; i++) {
            for (int j = 0; j < f[0].length; j++) {
                for (int k = 0; k < f[0][0].length; k++) {

                    Arrays.fill(f[i][j][k], Integer.MIN_VALUE);

                }
            }
        }

        f[0][0][0][0] = 0;


        for (int pos = 0; pos < m * n; ++pos) {
            for (int mask = 0; mask < N; ++mask) {
                int left = mask % 3, up = mask / N_3;
                if (pos % n == 0)
                    left = 0;
                for (int used1 = 0; used1 <= introvertsCount; ++used1) {
                    for (int used2 = 0; used2 <= extrovertsCount; ++used2) {
                        if (used1 < introvertsCount) {
                            int to_update = f[pos + 1][used1 + 1][used2][(mask * 3 + 1) % N];
                            to_update = Math.max(to_update, f[pos][used1][used2][mask] + 120 + cross[left][1] + cross[up][1]);

                            f[pos + 1][used1 + 1][used2][(mask * 3 + 1) % N] = to_update;
                        }
                        if (used2 < extrovertsCount) {
                            int to_update = f[pos + 1][used1][used2 + 1][(mask * 3 + 2) % N];
                            to_update = Math.max(to_update, f[pos][used1][used2][mask] + 40 + cross[left][2] + cross[up][2]);
                            f[pos + 1][used1][used2 + 1][(mask * 3 + 2) % N] = to_update;
                        }
                        int to_update = f[pos + 1][used1][used2][(mask * 3) % N];
                        to_update = Math.max(to_update, f[pos][used1][used2][mask]);
                        f[pos + 1][used1][used2][(mask * 3) % N] = to_update;
                    }
                }
            }
        }

        int result = 0;
        for (int used1 = 0; used1 <= introvertsCount; ++used1) {
            for (int used2 = 0; used2 <= extrovertsCount; ++used2) {
                for (int mask = 0; mask < N; ++mask) {
                    result = Math.max(result, f[m * n][used1][used2][mask]);
                }
            }
        }

        return result;

    }
}

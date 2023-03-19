package com.yuren.leetcodecnlearn.Q1400;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-03-20 00:01
 */
public class Q1463 {
    public int cherryPickup(int[][] grid) {
        int m = grid.length, n = grid[0].length, res = 0;
        int[][][] f = new int[m][n + 2][n + 2];
        f[0][1][n] = grid[0][0] + grid[0][n - 1];
        for (int i = 1; i < m; i++) {
            for (int j = 1; j <= Math.min(i + 1, n); j++) {
                for (int k = n; k >= Math.max(1, n - i); k--) {
                    if (j == k) {
                        int tmp1 = f[i - 1][j][k];
                        if (j > 0) tmp1 = Math.max(tmp1, f[i - 1][j - 1][k - 1]);
                        if (j < n - 1) tmp1 = Math.max(tmp1, f[i - 1][j + 1][k + 1]);
                        f[i][j][k] = tmp1 + grid[i][j - 1];
                    } else {
                        int tmp = 0;
                        for (int a = j - 1; a <= j + 1; a++) {
                            for (int b = k - 1; b <= k + 1; b++) {
                                tmp = Math.max(tmp, f[i - 1][a][b]);
                            }
                        }
                        f[i][j][k] = tmp + grid[i][j - 1] + grid[i][k - 1];
                    }
                }
            }
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                res = Math.max(res, f[m - 1][i][j]);
            }
        }
        return res;
    }
}

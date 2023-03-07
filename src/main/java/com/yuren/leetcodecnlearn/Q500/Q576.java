package com.yuren.leetcodecnlearn.Q500;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-03-13 22:28
 */
public class Q576 {
    private static final int MOD = (int) 1e9 + 7;
    int m, n, max;
    int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    int[][][] cache;

    public int findPaths(int m, int n, int max, int r, int c) {
        this.m = m;
        this.n = n;
        this.max = max;
        cache = new int[this.m][this.n][this.max + 1];
        for (int i = 0; i < this.m; i++) {
            for (int j = 0; j < this.n; j++) {
                for (int k = 0; k <= this.max; k++) {
                    cache[i][j][k] = -1;
                }
            }
        }
        return dfs(r, c, this.max);
    }

    int dfs(int x, int y, int k) {
        if (x < 0 || x >= m || y < 0 || y >= n) return 1;
        if (k == 0) return 0;
        if (cache[x][y][k] != -1) return cache[x][y][k];
        int ans = 0;
        for (int[] d : dirs) {
            int nx = x + d[0], ny = y + d[1];
            ans += dfs(nx, ny, k - 1);
            ans %= MOD;
        }
        cache[x][y][k] = ans;
        return ans;
    }
}

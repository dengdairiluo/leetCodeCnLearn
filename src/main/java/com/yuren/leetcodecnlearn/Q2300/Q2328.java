package com.yuren.leetcodecnlearn.Q2300;

import java.util.Arrays;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-03-31 21:55
 */
public class Q2328 {
    static final int MOD = (int) 1e9 + 7;
    static final int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    int m, n;
    int[][] grid, f;

    public int countPaths(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        this.grid = grid;
        f = new int[m][n];
        for (int i = 0; i < m; i++) Arrays.fill(f[i], -1);
        int ans = 0;
        for (int i = 0; i < m; ++i)
            for (int j = 0; j < n; ++j)
                ans = (ans + dfs(i, j)) % MOD;
        return ans;
    }

    int dfs(int i, int j) {
        if (f[i][j] != -1) return f[i][j];
        int res = 1;
        for (int[] d : dirs) {
            int x = i + d[0], y = j + d[1];
            if (0 <= x && x < m && 0 <= y && y < n && grid[x][y] > grid[i][j])
                res = (res + (dfs(x, y))) % MOD;
        }
        return f[i][j] = res;
    }
}

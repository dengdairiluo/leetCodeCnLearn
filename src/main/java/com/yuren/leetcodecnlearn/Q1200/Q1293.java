package com.yuren.leetcodecnlearn.Q1200;

import java.util.Arrays;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-01-15 23:06
 */
public class Q1293 {
    int res = Integer.MAX_VALUE;

    public int shortestPath(int[][] grid, int k) {
        if (grid == null || grid.length == 0) {
            return -1;
        }

        int m = grid.length, n = grid[0].length;
        if (k >= m + n - 3) {
            return m + n - 2;
        }
        int[][][] visited = new int[m][n][k + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(visited[i][j], Integer.MAX_VALUE);
            }
        }

        visited[0][0][0] = 0;
        dfs(grid, visited, 0, 0, 0, k);

        return res == Integer.MAX_VALUE ? -1 : res;
    }

    public void dfs(int[][] grid, int[][][] visited, int i, int j, int step, int k) {
        if (i < 0 || i == grid.length || j < 0 || j == grid[0].length) {
            return;
        }

        if (visited[i][j][k] == -1 || visited[i][j][k] <= step) {
            return;
        }

        if ((grid[i][j] == 1 && k == 0) || res == grid.length + grid[0].length - 1) {
            return;
        }

        if (i == grid.length - 1 && j == grid[0].length - 1) {
            res = Math.min(res, step);
            return;
        }

        if (grid[i][j] == 1) {
            k--;
        }

        visited[i][j][k] = -1;
        dfs(grid, visited, i + 1, j, step + 1, k);
        dfs(grid, visited, i, j + 1, step + 1, k);
        dfs(grid, visited, i - 1, j, step + 1, k);
        dfs(grid, visited, i, j - 1, step + 1, k);
        visited[i][j][k] = step;
    }
}

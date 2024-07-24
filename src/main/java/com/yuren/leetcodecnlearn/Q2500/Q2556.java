package com.yuren.leetcodecnlearn.Q2500;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-07-24 下午11:54
 */
public class Q2556 {
    private int[][] g;
    private int m, n;

    public boolean isPossibleToCutPath(int[][] grid) {
        g = grid;
        m = g.length;
        n = g[0].length;
        return !dfs(0, 0) || !dfs(0, 0);
    }

    // 返回能否到达终点
    private boolean dfs(int x, int y) {
        if (x == m - 1 && y == n - 1) return true;
        // 直接修改
        g[x][y] = 0;
        return x < m - 1 && g[x + 1][y] > 0 && dfs(x + 1, y) ||
                y < n - 1 && g[x][y + 1] > 0 && dfs(x, y + 1);
    }
}

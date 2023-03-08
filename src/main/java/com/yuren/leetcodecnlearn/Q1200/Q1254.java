package com.yuren.leetcodecnlearn.Q1200;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-01-05 00:15
 */
public class Q1254 {
    int[][] g;
    int n, m, ans;

    public int closedIsland(int[][] grid) {
        g = grid;
        n = g.length;
        m = g[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (g[i][j] == 0 && dfs(i, j)) ans++;
            }
        }
        return ans;
    }

    boolean dfs(int i, int j) {
        if (i < 0 || i >= n || j < 0 || j >= m) {
            // 终止条件1
            return false;
        }
        if (g[i][j] == 1) {
            // 终止条件2
            return true;
        }
        g[i][j] = 1;
        return dfs(i + 1, j) & dfs(i - 1, j) & dfs(i, j + 1) & dfs(i, j - 1);
    }
}

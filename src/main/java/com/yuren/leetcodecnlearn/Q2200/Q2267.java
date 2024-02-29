package com.yuren.leetcodecnlearn.Q2200;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-02-29 23:32
 */
public class Q2267 {
    int m, n;
    char[][] grid;
    boolean[][][] vis;

    public boolean hasValidPath(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        if ((m + n) % 2 == 0 || grid[0][0] == ')' || grid[m - 1][n - 1] == '(') return false; // 剪枝
        this.grid = grid;
        vis = new boolean[m][n][(m + n + 1) / 2];
        return dfs(0, 0, 0);
    }

    boolean dfs(int x, int y, int c) {
        if (c > m - x + n - y - 1) return false; // 剪枝：即使后面都是 ')' 也不能将 c 减为 0
        if (x == m - 1 && y == n - 1) return c == 1; // 终点一定是 ')'
        if (vis[x][y][c]) return false; // 重复访问
        vis[x][y][c] = true;
        c += grid[x][y] == '(' ? 1 : -1;
        return c >= 0 && (x < m - 1 && dfs(x + 1, y, c) || y < n - 1 && dfs(x, y + 1, c)); // 往下或者往右
    }
}

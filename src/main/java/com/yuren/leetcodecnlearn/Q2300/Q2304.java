package com.yuren.leetcodecnlearn.Q2300;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-03-19 23:56
 */
public class Q2304 {
    public int minPathCost(int[][] grid, int[][] moveCost) {
        int m = grid.length, n = grid[0].length;
        int[][] memo = new int[m][n];
        int ans = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) { // 枚举起点
            ans = Math.min(ans, dfs(0, j, memo, grid, moveCost));
        }
        return ans;
    }

    private int dfs(int i, int j, int[][] memo, int[][] grid, int[][] moveCost) {
        if (i == grid.length - 1) { // 递归边界
            return grid[i][j];
        }
        if (memo[i][j] != 0) { // 之前计算过
            return memo[i][j];
        }
        int res = Integer.MAX_VALUE;
        for (int k = 0; k < grid[0].length; k++) { // 移动到下一行的第 k 列
            res = Math.min(res, dfs(i + 1, k, memo, grid, moveCost) + moveCost[grid[i][j]][k]);
        }
        return memo[i][j] = res + grid[i][j]; // 记忆化
    }
}

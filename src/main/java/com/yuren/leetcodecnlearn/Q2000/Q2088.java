package com.yuren.leetcodecnlearn.Q2000;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-12-03 23:13
 */
public class Q2088 {

    public int countPyramids(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[] dp = new int[n];
        int ans = 0;
        System.arraycopy(grid[0], 0, dp, 0, n);
        ans += getCnt(dp, grid, 1, m, 1, n);

        dp = new int[n];
        System.arraycopy(grid[m - 1], 0, dp, 0, n);

        // 正的
        ans += getCnt(dp, grid, m - 2, -1, -1, n);

        return ans;
    }

    private int getCnt(int[] dp, int[][] grid, int startI, int endI, int moveI, int n) {
        int ans = 0;
        for (int i = startI; i != endI; i += moveI) {
            int[] copy = new int[n];
            copy[0] = grid[i][0];
            copy[n - 1] = grid[i][n - 1];
            for (int j = 1; j < n - 1; j++) {
                if (grid[i][j] != 1) {
                    continue;
                }
                copy[j] = Math.min(Math.min(dp[j - 1], dp[j + 1]), dp[j]) + 1;
                ans += copy[j] - 1;
            }
            dp = copy;
        }
        return ans;
    }
}

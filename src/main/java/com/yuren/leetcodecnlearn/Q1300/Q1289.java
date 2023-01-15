package com.yuren.leetcodecnlearn.Q1300;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-01-15 23:00
 */
public class Q1289 {
    public int minFallingPathSum(int[][] grid) {
        int n = grid.length;
        int[] dp = new int[n];
        System.arraycopy(grid[0], 0, dp, 0, n);
        for (int i = 1; i < n; i++) {
            int index1 = 0;
            int min1 = Integer.MAX_VALUE;
            int min2 = Integer.MAX_VALUE;
            for (int j = 0; j < n; j++) {

                if (dp[j] < min1) {
                    min2 = min1;
                    min1 = dp[j];
                    index1 = j;
                } else if (dp[j] < min2) {
                    min2 = dp[j];
                }
            }
            for (int j = 0; j < n; j++) {
                if (index1 == j) {
                    dp[j] = min2 + grid[i][j];
                } else {
                    dp[j] = min1 + grid[i][j];
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            min = Math.min(min, dp[i]);
        }
        return min;
    }
}

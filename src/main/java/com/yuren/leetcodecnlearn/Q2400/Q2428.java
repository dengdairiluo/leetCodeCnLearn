package com.yuren.leetcodecnlearn.Q2400;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-05-21 下午11:42
 */
public class Q2428 {
    public int maxSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int max = 0;
        for (int i = 1; i + 1 < m; i++) {
            for (int j = 1; j + 1 < n; j++) {
                int sum = grid[i][j];
                for (int x = -1; x <= 1; x += 2) {
                    for (int y = -1; y <= 1; y++) {
                        sum += grid[i + x][j + y];
                    }
                }
                max = Math.max(max, sum);
            }
        }
        return max;
    }
}

package com.yuren.leetcodecnlearn.Q1800;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-08-31 23:48
 */
public class Q1895 {
    private int[][] rowsum;
    private int[][] colsum;

    public int largestMagicSquare(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        rowsum = new int[m][n + 1];
        colsum = new int[m + 1][n];
        for (int i = 0; i < m; i++) {
            int sum = 0;
            for (int j = 0; j < n; j++)
                rowsum[i][j + 1] = sum += grid[i][j];
        }
        for (int j = 0; j < n; j++) {
            int sum = 0;
            for (int i = 0; i < m; i++)
                colsum[i + 1][j] = sum += grid[i][j];
        }
        for (int k = Math.min(m, n); k >= 2; k--) {
            for (int i = 0; i + k <= m; i++) {
                for (int j = 0; j + k <= n; j++) {
                    if (check(grid, i, j, k))
                        return k;
                }
            }
        }
        return 1;
    }

    private boolean check(int[][] grid, int i, int j, int k) {
        int sum = rowsum[i][j + k] - rowsum[i][j];
        for (int l = 1; l < k; l++) {
            if (rowsum[i + l][j + k] - rowsum[i + l][j] != sum)
                return false;
        }
        for (int l = 0; l < k; l++) {
            if (colsum[i + k][j + l] - colsum[i][j + l] != sum)
                return false;
        }
        int d1 = 0, d2 = 0;
        for (int l = 0; l < k; l++) {
            d1 += grid[i + l][j + l];
            d2 += grid[i + l][j + k - l - 1];
        }
        return d1 == sum && d2 == sum;
    }
}

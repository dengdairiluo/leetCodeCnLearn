package com.yuren.leetcodecnlearn.Q400;

public class Q463 {
    public int islandPerimeter(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int res;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                res = 0;
                if (grid[i][j] == 1) {
                    res = 4;
                    if (i + 1 < n && grid[i + 1][j] == 1) {
                        res--;
                    }
                    if (i - 1 >= 0 && grid[i - 1][j] == 1) {
                        res--;
                    }
                    if (j + 1 < m && grid[i][j + 1] == 1) {
                        res--;
                    }
                    if (j - 1 >= 0 && grid[i][j - 1] == 1) {
                        res--;
                    }
                }
                sum += res;
            }
        }
        return sum;
    }
}

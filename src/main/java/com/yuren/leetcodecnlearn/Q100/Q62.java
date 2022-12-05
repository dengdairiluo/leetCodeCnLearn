package com.yuren.leetcodecnlearn.Q100;

public class Q62 {
    public int uniquePaths1(int m, int n) {
        long res = 1;

        long x = n;
        long y = 1;
        while (x <= n + m - 2) {
            res = res * x / y;
            x++;
            y++;
        }
        return (int) res;

    }

    public int uniquePaths2(int m, int n) {
        int col = n;

        int[][] dp = new int[m][col];
        for (int c = 0; c < col; c++)
            dp[0][c] = 1;
        for (int r = 0; r < m; r++)
            dp[r][0] = 1;
        for (int r = 1; r < m; r++) {
            for (int c = 1; c < col; c++) {
                dp[r][c] = dp[r - 1][c] + dp[r][c - 1];
            }
        }

        return dp[m - 1][col - 1];


    }
}

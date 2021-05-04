package com.yuren.leetcodecnlearn;

public class Q807 {

    public static int maxIncreaseKeepingSkyline1(int[][] grid) {
        int[] rowMaxes = new int[grid.length];
        int[] colMaxes = new int[grid[0].length];

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                rowMaxes[r] = Math.max(rowMaxes[r], grid[r][c]);
                colMaxes[c] = Math.max(colMaxes[c], grid[r][c]);
            }
        }

        int ans = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                ans += Math.min(rowMaxes[r], colMaxes[c]) - grid[r][c];
            }
        }
        return ans;
    }
}

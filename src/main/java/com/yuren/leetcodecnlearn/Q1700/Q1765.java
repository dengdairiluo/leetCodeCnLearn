package com.yuren.leetcodecnlearn.Q1700;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-07-13 23:24
 */
public class Q1765 {
    public int[][] highestPeak(int[][] isWater) {
        int row = isWater.length;
        int col = isWater[0].length;
        int[][] dp = new int[row][col];

        // 最小值计算
        // 从左上到右下
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (isWater[i][j] == 1) {
                    continue;
                }
                int min = row * col;
                // 上位置的最小值
                if (i > 0) {
                    min = Math.min(min, dp[i - 1][j] + 1);
                }
                // 左位置的最小值
                if (j > 0) {
                    min = Math.min(min, dp[i][j - 1] + 1);
                }
                dp[i][j] = min;
            }
        }
        // 从右上到左下
        for (int i = row - 1; i >= 0; i--) {
            for (int j = col - 1; j >= 0; j--) {
                if (i < row - 1) {
                    dp[i][j] = Math.min(dp[i][j], dp[i + 1][j] + 1);
                }
                if (j < col - 1) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][j + 1] + 1);
                }
            }
        }
        return dp;
    }
}

package com.yuren.leetcodecnlearn.Q1300;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-01-15 23:03
 */
public class Q1292 {
    public int maxSideLength(int[][] mat, int threshold) {
        int ans = 0, m = mat.length, n = mat[0].length;
        int[][] preSum = new int[m + 1][n + 1];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                preSum[i + 1][j + 1] = preSum[i][j + 1] + preSum[i + 1][j] - preSum[i][j] + mat[i][j];
                // i + 1 - (ans + 1) 增加一位长度尝试是否合法
                if (i - ans >= 0 && j - ans >= 0 && preSum[i + 1][j + 1] - preSum[i - ans][j + 1] - preSum[i + 1][j - ans] + preSum[i - ans][j - ans] <= threshold) {
                    ans++;
                }
            }
        }
        return ans;
    }
}

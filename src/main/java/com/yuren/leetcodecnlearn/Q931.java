package com.yuren.leetcodecnlearn;

import java.util.Arrays;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-08-14 23:57
 */
public class Q931 {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int res = Integer.MAX_VALUE;
        // 初始化备忘录
        memo = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(memo[i], 66666);
        }
        // 遍历最后一行
        for (int j = 0; j < n; j++) {
            res = Math.min(res, dp(matrix, n - 1, j));
        }
        return res;
    }

    /**
     * 备忘录，防止重复计算
     */
    int[][] memo;

    // 递归函数 dp 从第一行（matrix[0][..]）向下落，落到位置 matrix[i][j] 的最小路径和为 dp(matrix, i, j)
    public int dp(int[][] matrix, int i, int j) {
        // 索引非法性的检查
        if (i < 0 || j < 0 || i >= matrix.length || j >= matrix[0].length) {
            return 99999;  // 返回特殊值
        }
        // base case
        if (i == 0) {
            return matrix[i][j];
        }
        // 先检查备忘录
        if (memo[i][j] != 66666) {
            return memo[i][j];
        }
        // 状态转移方程
        memo[i][j] = matrix[i][j] + min(
                dp(matrix, i - 1, j),
                dp(matrix, i - 1, j - 1),
                dp(matrix, i - 1, j + 1)
        );
        return memo[i][j];
    }

    public int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }
}

package com.yuren.leetcodecnlearn.Q600;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-02-25 23:49
 */
public class Q542 {
    public int[][] updateMatrix(int[][] mat) {
        //题解2： 动态规划DP
        //本题DP的转移方程：f(i,j) = 1 + min(f(i−1,j),f(i,j−1),f(i+1,j),f(i,j+1))  (若本身为0则距离为0)

        int m = mat.length;
        int n = mat[0].length;

        //创建dp数组
        //首先,给所有为0的方格赋0,给其他方格赋一个较大值
        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = Integer.MAX_VALUE / 2;
                }
            }
        }

        //先处理(i,j)点只往上往左移动的情况
        //两种位置的最优值与本身比较(因为本身可能为0)
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                //在上边界时
                if (i == 0 && j > 0) {
                    dp[i][j] = Math.min(dp[i][j], 1 + dp[i][j - 1]);
                }
                //在左边界时
                if (i > 0 && j == 0) {
                    dp[i][j] = Math.min(dp[i][j], 1 + dp[i - 1][j]);
                }
                //往左往上
                if (i > 0 && j > 0) {
                    dp[i][j] = Math.min(dp[i][j], 1 + Math.min(dp[i][j - 1], dp[i - 1][j]));
                }
            }
        }

        //往右往下的情况
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                //在下边界时
                if (i == m - 1 && j < n - 1) {
                    dp[i][j] = Math.min(dp[i][j], 1 + dp[i][j + 1]);
                }
                //在右边界时
                if (i < m - 1 && j == n - 1) {
                    dp[i][j] = Math.min(dp[i][j], 1 + dp[i + 1][j]);
                }
                //往右往下
                if (i < m - 1 && j < n - 1) {
                    dp[i][j] = Math.min(dp[i][j], 1 + Math.min(dp[i][j + 1], dp[i + 1][j]));
                }
            }
        }
        return dp;
    }
}

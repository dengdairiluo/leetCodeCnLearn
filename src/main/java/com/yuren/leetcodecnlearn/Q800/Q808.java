package com.yuren.leetcodecnlearn.Q800;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-06-21 23:17
 */
public class Q808 {
    public double soupServings(int N) {
        //边界异常处理；
        if (N >= 4800) {
            return 1.0;
        }
        int n = (int) Math.ceil(N / 25.0);
        double[][] dp = new double[n + 1][n + 1];
        //base case;
        dp[0][0] = 0.5;
        for (int i = 1; i < n + 1; i++) {
            dp[i][0] = 0;
            dp[0][i] = 1;
        }
        //dp;
        for (int i = 1; i < n + 1; i++) {
            int a1 = Math.max(i - 4, 0);
            int a2 = Math.max(i - 3, 0);
            int a3 = Math.max(i - 2, 0);
            int a4 = Math.max(i - 1, 0);
            for (int j = 1; j < n + 1; j++) {
                int b1 = j;
                int b2 = Math.max(j - 1, 0);
                int b3 = Math.max(j - 2, 0);
                int b4 = Math.max(j - 3, 0);
                dp[i][j] = 0.25 * (dp[a1][b1] + dp[a2][b2] + dp[a3][b3] + dp[a4][b4]);
            }
        }
        return dp[n][n];
    }
}

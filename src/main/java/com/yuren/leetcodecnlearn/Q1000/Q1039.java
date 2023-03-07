package com.yuren.leetcodecnlearn.Q1000;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-09-28 23:41
 */
public class Q1039 {
    public int minScoreTriangulation(int[] a) {
        if (a == null || a.length <= 0) {
            return 0;
        }
        int n = a.length;
        //从 0 ~ N-1 形成一个环
        //    1—3
        //   /    \
        //  5      1
        //   \    /
        //    1—4
        // dp[left][right] 代表left~right区间形成的环的最小得分值
        int[][] dp = new int[n][n];
        //枚举长度,从3开始
        for (int len = 3; len <= n; len++) {
            //枚举左端点
            for (int left = 0; left <= n - len; left++) {
                //left+len-1<N
                int right = left + len - 1;
                //init
                dp[left][right] = Integer.MAX_VALUE;
                //枚举区间内的所有的点(不包括端点)),将环分割成左右两部分
                for (int i = left + 1; i < right; i++) {
                    dp[left][right] = Math.min(dp[left][right], dp[left][i] + dp[i][right] + a[i] * a[left] * a[right]);
                }
            }
        }
        return dp[0][n - 1];
    }
}

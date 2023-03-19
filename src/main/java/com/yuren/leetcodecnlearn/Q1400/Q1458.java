package com.yuren.leetcodecnlearn.Q1400;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-03-19 23:53
 */
public class Q1458 {
    private static final int INF = Integer.MAX_VALUE / 2;

    public int maxDotProduct(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            dp[i][0] = -INF;
        }
        for (int j = 1; j <= n; j++) {
            dp[0][j] = -INF;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = max(nums1[i - 1] * nums2[j - 1],
                        dp[i - 1][j],
                        dp[i][j - 1],
                        dp[i - 1][j - 1] + nums1[i - 1] * nums2[j - 1]);
            }
        }
        return dp[m][n];
    }

    private int max(int a, int b, int c, int d) {
        return Math.max(Math.max(Math.max(a, b), c), d);
    }
}

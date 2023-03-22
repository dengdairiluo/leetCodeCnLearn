package com.yuren.leetcodecnlearn.Q1400;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-03-22 23:50
 */
public class Q1473 {
    public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
        // dp[i][j][k] 前i个房子，组成j个街区，最后一个房子被涂成第k种颜色的最小花费
        int[][][] dp = new int[m + 1][target + 1][n + 1];
        for (int i = 0; i <= m; ++i) {
            for (int j = 0; j <= target; ++j) {
                for (int k = 0; k <= n; ++k) {
                    dp[i][j][k] = Integer.MAX_VALUE / 2;
                }
            }
        }

        // 前0个房子，组成0个街区，最后一个房子被涂成第k种颜色的花费为0
        for (int k = 1; k <= n; ++k) {
            dp[0][0][k] = 0;
        }

        for (int i = 1; i <= m; ++i) {
            if (houses[i - 1] != 0) {
                // 当前房子已经被图上颜色了
                int k = houses[i - 1];
                for (int j = 1; j <= target; ++j) {
                    // 遍历前一个房子的所有颜色kk
                    for (int kk = 1; kk <= n; ++kk) {
                        // 如果前一个房子和当前房子的颜色相同
                        if (k == kk) {
                            dp[i][j][k] = Math.min(dp[i][j][k], dp[i - 1][j][kk]);
                        } else {
                            dp[i][j][k] = Math.min(dp[i][j][k], dp[i - 1][j - 1][kk]);
                        }
                    }
                }
            } else {
                for (int j = 1; j <= target; ++j) {
                    int min = Integer.MAX_VALUE / 2, secondMin = Integer.MAX_VALUE / 2, color = -1;
                    // 遍历前一个房子的最小值和第二小值
                    for (int kk = 1; kk <= n; ++kk) {
                        if (dp[i - 1][j - 1][kk] < secondMin) {
                            secondMin = dp[i - 1][j - 1][kk];
                            if (dp[i - 1][j - 1][kk] < min) {
                                secondMin = min;
                                min = dp[i - 1][j - 1][kk];
                                color = kk;
                            }
                        }
                    }

                    for (int k = 1; k <= n; ++k) {
                        // 当前房子与前一个房子颜色相同
                        dp[i][j][k] = dp[i - 1][j][k] + cost[i - 1][k - 1];

                        // 当前房子与前一个房子颜色不同
                        // 当前房子选择的颜色和前一个房子的最小值相同
                        if (k == color) {
                            dp[i][j][k] = Math.min(dp[i][j][k], secondMin + cost[i - 1][k - 1]);
                        } else {
                            dp[i][j][k] = Math.min(dp[i][j][k], min + cost[i - 1][k - 1]);
                        }
                    }

                }

            }

        }

        int res = Integer.MAX_VALUE / 2;
        for (int k = 1; k <= n; ++k) {
            res = Math.min(res, dp[m][target][k]);
        }
        return res == Integer.MAX_VALUE / 2 ? -1 : res;
    }
}

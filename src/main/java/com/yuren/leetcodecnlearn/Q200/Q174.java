package com.yuren.leetcodecnlearn.Q200;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2021-10-05 23:07
 */
public class Q174 {
    public int calculateMinimumHp(int[][] dungeon) {
        // 反向DP
        // 状态定义：dp[i][j]表示从[i,j]到终点需要的最小血量，dp[0][0]就是最小初始血量
        // 状态转移：1. 如果dungeon[i][j] == 0，那么，dp[i][j] = min(dp[i+1][j], dp[i][j+1])
        //          2. 如果dungeon[i][j] < 0，那么，dp[i][j] = min(dp[i+1][j], dp[i][j+1]) - dungeon[i][j]
        //          3. 如果dungeon[i][j] > 0，那么，dp[i][j] = max(1, min(dp[i+1][j], dp[i][j+1]) - dungeon[i][j])
        // 所以，三种情况可以统一成一种dp[i][j] = max(1, min(dp[i+1][j], dp[i][j+1]) - dungeon[i][j])
        // 处理边界：dp[m-1][n-1] = max(1, 1-dungeon[m-1][n-1])，右边和下边，相临的元素只有一个，特殊处理一下。

        int m = dungeon.length;
        int n = dungeon[0].length;
        int[][] dp = new int[m][n];

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i == m - 1 && j == n - 1) {
                    dp[i][j] = Math.max(1, 1 - dungeon[m - 1][n - 1]);
                } else if (i == m - 1) {
                    dp[i][j] = Math.max(1, dp[i][j + 1] - dungeon[i][j]);
                } else if (j == n - 1) {
                    dp[i][j] = Math.max(1, dp[i + 1][j] - dungeon[i][j]);
                } else {
                    dp[i][j] = Math.max(1, Math.min(dp[i + 1][j], dp[i][j + 1]) - dungeon[i][j]);
                }
            }
        }

        return dp[0][0];
    }
}

package com.yuren.leetcodecnlearn.Q2700;

import java.util.Arrays;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author 10204
 * @date 2024-10-26 20:56
 */
public class Q2742 {
    public int paintWalls(int[] cost, int[] time) {
        int n = cost.length;
        int[][] memo = new int[n][n * 2];
        for (int[] row : memo) {
            // -1 表示没有计算过
            Arrays.fill(row, -1);
        }
        return dfs(n - 1, 0, cost, time, memo);
    }

    private int dfs(int i, int j, int[] cost, int[] time, int[][] memo) {
        // 剩余的墙都可以免费刷
        if (j > i) {
            return 0;
        }
        // 上面 if 不成立，意味着 j < 0，不符合题目要求
        if (i < 0) {
            // 防止加法溢出
            return Integer.MAX_VALUE / 2;
        }
        // 加上偏移量，防止出现负数
        int k = j + memo.length;
        // 之前计算过
        if (memo[i][k] != -1) {
            return memo[i][k];
        }
        int res1 = dfs(i - 1, j + time[i], cost, time, memo) + cost[i];
        int res2 = dfs(i - 1, j - 1, cost, time, memo);
        return memo[i][k] = Math.min(res1, res2);
    }
}

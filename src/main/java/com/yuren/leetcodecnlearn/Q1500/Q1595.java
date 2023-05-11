package com.yuren.leetcodecnlearn.Q1500;

import java.util.List;

/**
 * Created with Intellij IDEA.
 * Description:
 * refer to <a href="https://leetcode.com/problems/minimum-cost-to-connect-two-groups-of-points/discuss/855041/C%2B%2BPython-DP-using-mask">reference</a>
 *
 * @author lujiang
 * @date 2023-05-11 23:31
 */
public class Q1595 {
    int[][] dp = new int[13][1 << 12];
    int m;
    int n;
    int[] minCostForRight;
    List<List<Integer>> cost;

    public int connectTwoGroups(List<List<Integer>> cost) {
        m = cost.size();
        n = cost.get(0).size();
        this.cost = cost;
        minCostForRight = new int[n];
        for (int j = 0; j < n; j++) {
            int minCost = Integer.MAX_VALUE;
            for (int i = 0; i < m; i++) {
                minCost = Math.min(minCost, cost.get(i).get(j));
            }
            minCostForRight[j] = minCost;
        }

        return dfs(0, 0);
    }

    public int dfs(int idx, int mask) {
        if (dp[idx][mask] != 0) {
            return dp[idx][mask];
        }

        int res = 0;
        if (idx < m) {
            res = Integer.MAX_VALUE;
            for (int j = 0; j < n; j++) {
                res = Math.min(res, cost.get(idx).get(j) + dfs(idx + 1, mask | (1 << j)));
            }
        } else {
            for (int j = 0; j < n; j++) {
                if ((mask & (1 << j)) == 0) {
                    res += minCostForRight[j];
                }
            }
        }
        dp[idx][mask] = res;
        return res;
    }
}

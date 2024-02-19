package com.yuren.leetcodecnlearn.Q2200;

import java.util.Arrays;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-02-20 00:00
 */
public class Q2247 {
    int[][] mp;
    int[][] dp;

    public void cal(int u, int x, int[] e, int y) {
        //dp[u][x]=e[y]
        int sta = u + (1 << e[1 - y]);
        if (dp[sta][2] < dp[u][2] + e[2]) {
            dp[sta][2] = dp[u][2] + e[2];
            dp[sta][0] = e[1 - y];
            dp[sta][1] = dp[u][1 - x];
        }
    }

    public int maximumCost(int n, int[][] highways, int w) {
        if (w >= n) return -1;
        int ans = -1;
        mp = new int[n][n];
        dp = new int[1 << n][3];
        for (int[] p : mp)
            Arrays.fill(p, -1);
        for (int[] p : dp)
            Arrays.fill(p, -1);
        for (int[] e : highways) {
            mp[e[0]][e[1]] = e[2];
            mp[e[1]][e[0]] = e[2];
        }
        for (int i = 0; i < n; i++) {
            dp[1 << i][0] = i;
            dp[1 << i][2] = 0;
            dp[1 << i][1] = i;
        }
        System.out.println((1 << 1) ^ 3);
        for (int i = 1; i < (1 << n); i++) {
            int z = Integer.bitCount(i);
            if (z > w + 1) continue;
            if (dp[i][2] == -1) continue;
            for (int[] e : highways) {
                if (((((1 << e[0]) | i) == i) ^ (((1 << e[1]) | i) == i))) {
                    if (e[0] == dp[i][0])
                        cal(i, 0, e, 0);
                    if (e[1] == dp[i][0])
                        cal(i, 0, e, 1);
                    if (e[1] == dp[i][1])
                        cal(i, 1, e, 1);
                    if (e[0] == dp[i][1])
                        cal(i, 1, e, 0);
                }
            }
            if (z == w + 1) ans = Math.max(ans, dp[i][2]);
        }
        return ans;
    }
}

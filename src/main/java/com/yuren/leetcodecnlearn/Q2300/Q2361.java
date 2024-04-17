package com.yuren.leetcodecnlearn.Q2300;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-04-17 下午11:14
 */
public class Q2361 {
    public long[] minimumCosts(int[] regular, int[] express, int expressCost) {
        int n = regular.length;
        long[] costs = new long[n];
        long dp0 = 0, dp1 = expressCost;
        for (int i = 0; i < n; i++) {
            long dp0New = Math.min(dp0 + regular[i], dp1 + Math.min(regular[i], express[i]));
            long dp1New = Math.min(dp0 + expressCost, dp1) + express[i];
            dp0 = dp0New;
            dp1 = dp1New;
            costs[i] = Math.min(dp0, dp1);
        }
        return costs;
    }
}

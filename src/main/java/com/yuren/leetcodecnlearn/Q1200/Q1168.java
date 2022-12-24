package com.yuren.leetcodecnlearn.Q1200;

import java.util.Arrays;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-11-23 23:26
 */
public class Q1168 {
    int[] costs;
    int[] parents;

    public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
        costs = wells;
        parents = new int[n];
        for (int i = 0; i < n; i++) {
            parents[i] = i;
        }
        int sum = 0;
        for (int well : wells) {
            sum += well;
        }
        Arrays.sort(pipes, (a, b) -> a[2] - b[2]);
        for (int[] pipe : pipes) {
            int a = pipe[0] - 1;
            int b = pipe[1] - 1;
            int c = pipe[2];
            if (isConnected(a, b)) continue;
            int cost1 = costs[root(a)];
            int cost2 = costs[root(b)];
            int maxCost = Math.max(cost1, cost2);
            if (maxCost > c) {
                sum = sum - maxCost + c;
                connect(a, b);
            }
        }
        return sum;
    }

    private boolean isConnected(int a, int b) {
        return root(a) == root(b);
    }

    private void connect(int a, int b) {
        int ra = root(a);
        int rb = root(b);
        if (ra == rb) {
            return;
        }
        if (costs[ra] < costs[rb]) {
            parents[rb] = ra;
        } else {
            parents[ra] = rb;
        }
    }

    private int root(int a) {
        if (a != parents[a]) {
            parents[a] = root(parents[a]);
        }
        return parents[a];
    }
}

package com.yuren.leetcodecnlearn.Q2000;

import java.util.*;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-12-04 23:23
 */
public class Q2093 {
    public int minimumCost(int n, int[][] highways, int discounts) {
        int[] dist = new int[n];
        int inf = Integer.MAX_VALUE / 2;
        Arrays.fill(dist, inf);
        dist[0] = 0;

        List<int[]>[] g = new List[n];
        for (int i = 0; i < n; i++) {
            g[i] = new ArrayList();
        }
        for (int[] h : highways) {
            int l = h[0];
            int r = h[1];
            int t = h[2];
            g[l].add(new int[]{r, t});
            g[r].add(new int[]{l, t});
        }
        PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        q.add(new int[]{0, 0});
        while (!q.isEmpty()) {
            int[] p = q.poll();
            int id = p[0];
            int toll = p[1];

            if (dist[id] < toll) {
                continue;
            }

            for (int[] e : g[id]) {
                int next = e[0];
                int nextToll = e[1];
                int d = dist[id] + nextToll;
                if (d < dist[next]) {
                    dist[next] = d;
                    q.add(new int[]{next, d});
                }
            }
        }

        for (int i = 0; i < discounts; i++) {
            int[] pre = dist.clone();
            for (int[] h : highways) {
                int l = h[0];
                int r = h[1];
                int cost = h[2] / 2;
                if (pre[l] + cost < dist[r]) {
                    dist[r] = pre[l] + cost;
                }
                if (pre[r] + cost < dist[l]) {
                    dist[l] = pre[r] + cost;
                }
            }
        }
        return dist[n - 1] == inf ? -1 : dist[n - 1];
    }
}

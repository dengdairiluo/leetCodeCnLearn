package com.yuren.leetcodecnlearn.Q2200;

import java.util.*;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-01-28 23:20
 */
public class Q2203 {
    public long minimumWeight(int n, int[][] edges, int src1, int src2, int dest) {
        List<List<int[]>> g = new ArrayList<>();
        List<List<int[]>> dg = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            g.add(new ArrayList<>());
            dg.add(new ArrayList<>());
        }
        for (int[] edge :
                edges) {
            int from = edge[0], to = edge[1], weight = edge[2];
            g.get(from).add(new int[]{to, weight});
            dg.get(to).add(new int[]{from, weight});
        }

        long[] d1 = spfa(src1, g);
        long[] d2 = spfa(src2, g);
        long[] d3 = spfa(dest, dg);
        long ret = inf;
        for (int i = 0; i < n; i++) {
            long d = d1[i] + d2[i] + d3[i];
            if (d1[i] != inf && d2[i] != inf && d3[i] != inf) ret = Math.min(ret, d);
        }

        return ret >= inf ? -1 : ret;
    }

    long inf = (long) 1e15;

    public long[] spfa(int src, List<List<int[]>> g) {
        long[] dist = new long[g.size()];
        boolean[] st = new boolean[g.size()];
        Arrays.fill(dist, inf);
        dist[src] = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        st[src] = true;
        while (!q.isEmpty()) {
            int t = q.poll();
            st[t] = false;
            for (int[] next : g.get(t)) {
                int point = next[0], weight = next[1];
                if (dist[point] > dist[t] + weight) {
                    dist[point] = dist[t] + weight;
                    if (!st[point]) {
                        q.offer(point);
                        st[point] = true;
                    }
                }
            }
        }

        return dist;
    }

    public long[] dijkstra(int src, List<List<int[]>> g) {
        int n = g.size();
        long[] dist = new long[n];
        Arrays.fill(dist, inf);
        dist[src] = 0;
        boolean[] st = new boolean[n];
        Queue<Integer> q = new PriorityQueue<>((a, b) -> (int) (dist[a] - dist[b]));
        q.add(src);

        while (!q.isEmpty()) {
            int t = q.poll();
            if (st[t]) continue;
            st[t] = true;
            for (int[] next :
                    g.get(t)) {
                int point = next[0], weight = next[1];
                if (!st[point] && dist[t] + weight < dist[point]) {
                    dist[point] = dist[t] + weight;
                    q.offer(point);
                }
            }
        }

        return dist;
    }
}

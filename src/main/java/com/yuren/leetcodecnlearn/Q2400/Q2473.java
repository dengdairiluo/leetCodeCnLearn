package com.yuren.leetcodecnlearn.Q2400;

import java.util.*;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-06-12 下午11:23
 */
public class Q2473 {
    public long[] minCost(int n, int[][] roads, int[] appleCost, int k) {
        // res[i] = dist[i][j] * (k + 1) + cost[j]
        List<long[]>[] graph = new List[n];
        Arrays.setAll(graph, o -> new ArrayList<>());
        for (int[] road : roads) {
            graph[road[0] - 1].add(new long[]{road[1] - 1, (long) (k + 1) * road[2]});
            graph[road[1] - 1].add(new long[]{road[0] - 1, (long) (k + 1) * road[2]});
        }

        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[1]));
        long[] res = new long[n];
        for (int i = 0; i < n; i++) {
            res[i] = appleCost[i];
        }
        for (int i = 0; i < n; i++) {
            pq.offer(new long[]{i, appleCost[i]});
        }

        while (!pq.isEmpty()) {
            long[] curr = pq.poll();
            int node = (int) curr[0];
            if (res[node] < curr[1]) continue;
            for (long[] next : graph[node]) {
                int nextNode = (int) next[0];
                if (res[nextNode] > curr[1] + next[1]) {
                    res[nextNode] = curr[1] + next[1];
                    pq.offer(new long[]{nextNode, res[nextNode]});
                }
            }
        }

        return res;
    }
}

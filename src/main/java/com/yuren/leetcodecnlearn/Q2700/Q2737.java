package com.yuren.leetcodecnlearn.Q2700;

import java.util.*;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author 10204
 * @date 2024-10-23 00:53
 */
public class Q2737 {
    static final int INFINITY = Integer.MAX_VALUE / 2;

    public int minimumDistance(int n, List<List<Integer>> edges, int s, int[] marked) {
        List<int[]>[] adjacentArr = new List[n];
        for (int i = 0; i < n; i++) {
            adjacentArr[i] = new ArrayList<int[]>();
        }
        for (List<Integer> edge : edges) {
            int u = edge.get(0), v = edge.get(1), w = edge.get(2);
            adjacentArr[u].add(new int[]{v, w});
        }
        int[] distances = dijkstra(adjacentArr, s);
        int minDistance = INFINITY;
        for (int node : marked) {
            minDistance = Math.min(minDistance, distances[node]);
        }
        return minDistance != INFINITY ? minDistance : -1;
    }

    public int[] dijkstra(List<int[]>[] adjacentArr, int source) {
        int n = adjacentArr.length;
        int[] distances = new int[n];
        Arrays.fill(distances, INFINITY);
        distances[source] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.offer(new int[]{source, 0});
        while (!pq.isEmpty()) {
            int[] pair = pq.poll();
            int curr = pair[0], distance = pair[1];
            if (distances[curr] < distance) {
                continue;
            }
            for (int[] adjacent : adjacentArr[curr]) {
                int next = adjacent[0], weight = adjacent[1];
                if (distances[next] > distance + weight) {
                    distances[next] = distance + weight;
                    pq.offer(new int[]{next, distances[next]});
                }
            }
        }
        return distances;
    }
}

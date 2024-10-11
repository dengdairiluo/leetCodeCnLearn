package com.yuren.leetcodecnlearn.Q2700;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author 10204
 * @date 2024-10-12 00:30
 */
public class Q2714 {
    private  int[] edge, next, head, weight;
    int index;
    void add(int u, int v, int w) {
        edge[index] = v;
        weight[index] = w;
        next[index] = head[u];
        head[u] = index++;
    }

    public int shortestPathWithHops(int n, int[][] edges, int s, int d, int k) {

        int m = edges.length;
        edge = new int[m << 1];
        next = new int[m << 1];
        weight = new int[m << 1];
        head = new int[n];

        for(int i = 0; i < n; ++i)
            head[i] = -1;
        index = 0;

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], w = edge[2];
            add(u, v, w);
            add(v, u, w);
        }

        int[][] distances = new int[n][k+1];
        for (int[] distance : distances)
            Arrays.fill(distance, Integer.MAX_VALUE);

        distances[s][k] = 0;
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[]{s, k, 0});

        while (!que.isEmpty()) {

            int[] cur = que.poll();
            int u = cur[0], count = cur[1], distance = cur[2];

            if (distance > distances[u][count]  || u == d)
                continue;

            for (int index = head[u]; index != -1; index = next[index]) {

                int v = edge[index],  w = weight[index];

                if (distances[v][count] > distance + w) {
                    distances[v][count] = distance + w;
                    que.offer(new int[]{v, count, distances[v][count]});

                    if (count > 0)
                        distances[v][count - 1] = Math.min(distances[v][count - 1], distances[v][count]);
                }

                if (count > 0 && distances[v][count - 1] > distance) {
                    distances[v][count - 1] = distance;
                    que.add(new int[]{v, count - 1, distance});

                    if (count - 1 > 0)
                        distances[v][count - 2] = Math.min(distances[v][count - 2], distance);
                }

            }
        }

        int result = Integer.MAX_VALUE;
        for (int x : distances[d])
            result = Math.min(result, x);
        return result;

    }
}

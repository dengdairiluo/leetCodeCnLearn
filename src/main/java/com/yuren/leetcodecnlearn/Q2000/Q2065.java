package com.yuren.leetcodecnlearn.Q2000;

import java.util.*;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-11-20 22:33
 */
public class Q2065 {
    // LC2065
    int max = 0;

    // 限时在图中行走并回到出发城市, 每个城市可以经过不止一次, 路径耗时, 城市有值, 值只取一次, 选值最高的路径
    public int maximalPathQuality(int[] values, int[][] edges, int maxTime) {
        int n = values.length;
        // 构造邻接表
        int[] freq = new int[n];
        List<int[]>[] grid = new ArrayList[n];
        Arrays.setAll(grid, e -> new ArrayList<>());
        for (int[] edge : edges) {
            int a = edge[0], b = edge[1], c = edge[2];
            grid[a].add(new int[]{b, c});
            grid[b].add(new int[]{a, c});
        }

        int[] dis = dijkstra(grid, 0);


        freq[0] = 1;
        helper(0, values[0], maxTime, freq, grid, dis, values);
        return max;
    }

    private int[] dijkstra(List<int[]>[] grid, int i) {

        int[] dis = new int[grid.length];

        Arrays.fill(dis, Integer.MAX_VALUE / 2);
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));

        pq.add(new int[]{0, 0});
        while (!pq.isEmpty()) {

            int[] poll = pq.poll();
            int j = poll[0];
            if (dis[j] != Integer.MAX_VALUE / 2) {
                continue;
            }
            dis[j] = poll[1];
            for (int[] g : grid[j]) {
                int a = g[0], b = g[1];
                if (dis[a] > dis[j] + b) {
                    pq.add(new int[]{a, dis[j] + b});
                }
            }
        }

        return dis;
    }

    private void helper(int cur, int gain, int remainTime, int[] freq, List<int[]>[] mtx, int[] shortest, int[] values) {
        if (cur == 0) {
            max = Math.max(max, gain);
        }
        if (freq[cur] == 0) gain += values[cur];
        freq[cur]++;
        for (int[] next : mtx[cur]) {
            if (remainTime < next[1]) continue;
            if (remainTime - next[1] < shortest[next[0]]) continue; // 剪枝
            helper(next[0], gain, remainTime - next[1], freq, mtx, shortest, values);
        }
        freq[cur]--; // 记得复位
    }
}

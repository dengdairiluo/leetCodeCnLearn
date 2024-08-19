package com.yuren.leetcodecnlearn.Q2600;

import java.util.*;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-08-19 23:04
 */
public class Q2608 {
    private List<Integer>[] g;
    private int[] dis; // dis[i] 表示从 start 到 i 的最短路长度

    public int findShortestCycle(int n, int[][] edges) {
        g = new ArrayList[n];
        Arrays.setAll(g, e -> new ArrayList<>());
        for (int[] e : edges) {
            int x = e[0], y = e[1];
            g[x].add(y);
            g[y].add(x); // 建图
        }
        dis = new int[n];

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; ++i) // 枚举每个起点跑 BFS
            ans = Math.min(ans, bfs(i));
        return ans < Integer.MAX_VALUE ? ans : -1;
    }

    private int bfs(int start) {
        int ans = Integer.MAX_VALUE;
        Arrays.fill(dis, -1);
        dis[start] = 0;
        Deque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{start, -1});
        while (!q.isEmpty()) {
            int[] p = q.poll();
            int x = p[0], fa = p[1];
            for (int y : g[x])
                if (dis[y] < 0) { // 第一次遇到
                    dis[y] = dis[x] + 1;
                    q.add(new int[]{y, x});
                } else if (y != fa) // 第二次遇到
                    ans = Math.min(ans, dis[x] + dis[y] + 1);
        }
        return ans;
    }
}

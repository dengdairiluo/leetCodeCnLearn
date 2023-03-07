package com.yuren.leetcodecnlearn.Q700;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-05-24 23:20
 */
public class Q743 {
    int N = 110, M = 6010;
    // 邻接表
    int[] he = new int[N], e = new int[M], ne = new int[M], w = new int[M];
    // dist[x] = y 代表从「源点/起点」到 x 的最短距离为 y
    int[] dist = new int[N];
    // 记录哪些点已经被更新过
    boolean[] vis = new boolean[N];
    int n, k, idx;
    int INF = 0x3f3f3f3f;

    void add(int a, int b, int c) {
        e[idx] = b;
        ne[idx] = he[a];
        he[a] = idx;
        w[idx] = c;
        idx++;
    }

    public int networkDelayTime(int[][] ts, int _n, int _k) {
        n = _n;
        k = _k;
        // 初始化链表头
        Arrays.fill(he, -1);
        // 存图
        for (int[] t : ts) {
            int u = t[0], v = t[1], c = t[2];
            add(u, v, c);
        }
        // 最短路
        dijkstra();
        // 遍历答案
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            ans = Math.max(ans, dist[i]);
        }
        return ans > INF / 2 ? -1 : ans;
    }

    void dijkstra() {
        // 起始先将所有的点标记为「未更新」和「距离为正无穷」
        Arrays.fill(vis, false);
        Arrays.fill(dist, INF);
        // 只有起点最短距离为 0
        dist[k] = 0;
        // 使用「优先队列」存储所有可用于更新的点
        // 以 (点编号, 到起点的距离) 进行存储，优先弹出「最短距离」较小的点
        PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        q.add(new int[]{k, 0});
        while (!q.isEmpty()) {
            // 每次从「优先队列」中弹出
            int[] poll = q.poll();
            int id = poll[0], step = poll[1];
            // 如果弹出的点被标记「已更新」，则跳过
            if (vis[id]) continue;
            // 标记该点「已更新」，并使用该点更新其他点的「最短距离」
            vis[id] = true;
            for (int i = he[id]; i != -1; i = ne[i]) {
                int j = e[i];
                if (dist[j] > dist[id] + w[i]) {
                    dist[j] = dist[id] + w[i];
                    q.add(new int[]{j, dist[j]});
                }
            }
        }
    }
}

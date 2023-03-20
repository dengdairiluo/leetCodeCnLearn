package com.yuren.leetcodecnlearn.Q1400;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-03-21 00:20
 */
public class Q1466 {
    private int[] he, e, ne, w;
    private int idx = 0;

    public int minReorder(int n, int[][] connections) {
        he = new int[n];
        Arrays.fill(he, -1);
        int m = connections.length * 2;
        e = new int[m];
        ne = new int[m];
        w = new int[m];
        for (int[] conn : connections) {
            add(conn[0], conn[1], 1);
            add(conn[1], conn[0], 0);
        }
        Queue<Integer> q = new ArrayDeque<>();
        boolean[] vis = new boolean[n];
        q.offer(0);
        vis[0] = true;
        int ans = 0;
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int i = he[cur]; i != -1; i = ne[i]) {
                int next = e[i];
                if (!vis[next]) {
                    ans += w[i];
                    vis[next] = true;
                    q.offer(next);
                }
            }
        }
        return ans;
    }

    private void add(int a, int b, int c) {
        e[idx] = b;
        w[idx] = c;
        ne[idx] = he[a];
        he[a] = idx++;
    }
}

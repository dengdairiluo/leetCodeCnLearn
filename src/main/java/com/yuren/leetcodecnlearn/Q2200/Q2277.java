package com.yuren.leetcodecnlearn.Q2200;

import java.util.*;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-03-05 23:07
 */
public class Q2277 {
    public int[] closestNode(int n, int[][] edges, int[][] query) {
        //1.建图
        Set<Integer>[] graph = new Set[n];
        Arrays.setAll(graph, o -> new HashSet<>());
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            graph[u].add(v);
            graph[v].add(u);
        }
        //2.删边，定深
        int[] depth = new int[n];
        int[] parent = new int[n];
        parent[0] = -1;
        Arrays.fill(depth, -1);
        depth[0] = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int next : graph[node]) {
                parent[next] = node;
                depth[next] = depth[node] + 1;
                graph[next].remove(node);
                queue.offer(next);
            }
        }

        int m = query.length;
        int[] ans = new int[m];
        for (int i = 0; i < m; i++) {
            int[] q = query[i];
            int a = q[0];
            int b = q[1];
            int c = q[2];

            int d = getPublicParent(a, b, parent, depth);
            int e = getPublicParent(a, c, parent, depth);
            int f = getPublicParent(b, c, parent, depth);

            int res = Math.min(depth[c] - depth[d], Math.min(depth[c] - depth[e], depth[c] - depth[f]));
            int num = depth[c] - depth[d] == res ? d : (depth[c] - depth[e] == res ? e : f);

            ans[i] = num;
        }
        return ans;
    }

    private int getPublicParent(int a, int b, int[] parent, int[] depth) {
        while (depth[a] > depth[b]) {
            a = parent[a];
        }

        while (depth[b] > depth[a]) {
            b = parent[b];
        }

        while (a != b) {
            a = parent[a];
            b = parent[b];
        }
        return a;
    }
}

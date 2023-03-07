package com.yuren.leetcodecnlearn.Q200;

import java.util.*;

public class Q261 {
    // 图是树的话
    // 首先：节点个数 = 边数-1
    // 其次：所有节点都是联通的
    public boolean validTree(int n, int[][] edges) {
        // 节点个数 如果不等于 边数+1，return false
        if (n != edges.length + 1) {
            return false;
        }
        // 对于每个节点都搞一个邻接表
        ArrayList<Integer>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        // 添加关系
        for (int[] e : edges) {
            adj[e[0]].add(e[1]);
            adj[e[1]].add(e[0]);
        }
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        queue.offer(0);
        set.add(0);

        while (!queue.isEmpty()) {
            Integer v = queue.poll();
            for (Integer next : adj[v]) {
                if (!set.contains(next)) {
                    set.add(next);
                    queue.offer(next);
                }
            }
        }
        return set.size() == n;
    }
}

package com.yuren.leetcodecnlearn.Q1100;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-10-07 23:49
 */
public class Q1059 {
    public boolean leadsToDestination(int n, int[][] edges, int source, int destination) {
        List<Integer>[] adj = new ArrayList<>[n];
        for (int i = 0; i < n; ++i) {
            adj[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            adj[edge[0]].add(edge[1]);
        }
        return dfs(adj, source, destination, new boolean[n], new boolean[n]);
    }

    public boolean dfs(List<Integer>[] adj, int v, int d, boolean[] visited, boolean[] onPath) {
        if (adj[v].size() == 0) {
            return v == d;
        }
        visited[v] = true;
        onPath[v] = true;
        for (int next : adj[v]) {
            if ((visited[next] && onPath[next]) || (!visited[next] && !dfs(adj, next, d, visited, onPath))) {
                return false;
            }
        }
        onPath[v] = false;
        return true;
    }
}

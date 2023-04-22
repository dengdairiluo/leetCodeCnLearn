package com.yuren.leetcodecnlearn.Q1500;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-04-22 23:51
 */
public class Q1548 {
    int n;
    String[] names;
    String[] targetPath;
    static int INF = (int) 1e9 + 1;
    List<Integer>[] adj;
    Integer[][] memo;
    int[][] next;

    public List<Integer> mostSimilar(int n, int[][] edges, String[] names, String[] targetPath) {
        this.n = n;
        this.names = names;
        this.targetPath = targetPath;
        buildAdjacencyList(edges);
        memo = new Integer[n + 1][targetPath.length + 1];
        next = new int[n][targetPath.length];

        int minDist = INF;
        int begin = -1;
        for (int i = 0; i < n; i++) {
            int res = dfs(i, 0);
            if (res < minDist) {
                minDist = res;
                begin = i;
            }
        }

        List<Integer> ans = new ArrayList<>();
        for (int cur = begin, i = 0; i < targetPath.length; i++) {
            ans.add(cur);
            cur = next[cur][i];
        }
        return ans;
    }

    private int dfs(int u, int cur) {
        if (memo[u][cur] != null) {
            return memo[u][cur];
        }
        if (cur == targetPath.length) {
            return memo[u][cur] = 0;
        }
        int ans = INF;
        int inc = names[u].equals(targetPath[cur]) ? 0 : 1;
        for (int v : adj[u]) {
            int res = dfs(v, cur + 1);
            if (ans > res + inc) {
                ans = res + inc;
                next[u][cur] = v;
            }
        }
        return memo[u][cur] = ans;
    }

    private void buildAdjacencyList(int[][] edges) {
        adj = new List[n];
        Arrays.setAll(adj, i -> new ArrayList<>());
        for (int[] e : edges) {
            adj[e[0]].add(e[1]);
            adj[e[1]].add(e[0]);
        }
    }
}

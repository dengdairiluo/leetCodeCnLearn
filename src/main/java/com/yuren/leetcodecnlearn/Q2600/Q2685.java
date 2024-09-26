package com.yuren.leetcodecnlearn.Q2600;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author 10204
 * @date 2024-09-26 23:59
 */
public class Q2685 {
    private List<Integer>[] g;
    private boolean vis[];
    private int v, e;

    public int countCompleteComponents(int n, int[][] edges) {
        g = new ArrayList[n];
        Arrays.setAll(g, e -> new ArrayList<>());
        for (int[] e : edges) {
            int x = e[0], y = e[1];
            g[x].add(y);
            g[y].add(x); // 建图
        }

        int ans = 0;
        vis = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                v = 0;
                e = 0;
                dfs(i);
                if (e == v * (v - 1))
                    ans++;
            }
        }
        return ans;
    }

    private void dfs(int x) {
        vis[x] = true;
        v++;
        e += g[x].size();
        for (Integer y : g[x])
            if (!vis[y])
                dfs(y);
    }
}

package com.yuren.leetcodecnlearn.Q2200;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-02-19 23:59
 */
public class Q2246 {
    List<Integer>[] g;
    String s;
    int ans;

    public int longestPath(int[] parent, String s) {
        this.s = s;
        int n = parent.length;
        g = new ArrayList[n];
        Arrays.setAll(g, e -> new ArrayList<>());
        for (int i = 1; i < n; i++) g[parent[i]].add(i);

        dfs(0);
        return ans + 1;
    }

    int dfs(int x) {
        int maxLen = 0;
        for (int y : g[x]) {
            int len = dfs(y) + 1;
            if (s.charAt(y) != s.charAt(x)) {
                ans = Math.max(ans, maxLen + len);
                maxLen = Math.max(maxLen, len);
            }
        }
        return maxLen;
    }
}

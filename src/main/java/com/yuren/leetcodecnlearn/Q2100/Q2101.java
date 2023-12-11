package com.yuren.leetcodecnlearn.Q2100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-12-09 23:56
 */
public class Q2101 {
    List<Integer>[] g;

    public int maximumDetonation(int[][] bombs) {
        int n = bombs.length, ans = 0;
        boolean[] visited = new boolean[n];
        g = new List[n];
        Arrays.setAll(g, e -> new ArrayList<>());
        for (int i = 0; i < n; ++i) {
            int[] bombI = bombs[i];
            for (int j = i + 1; j < n; ++j) {
                int[] bombJ = bombs[j];
                long distance = ((long) bombI[0] - bombJ[0]) * (bombI[0] - bombJ[0]) + ((long) bombI[1] - bombJ[1]) * (bombI[1] - bombJ[1]);
                if (distance <= (long) bombI[2] * bombI[2]) {
                    g[i].add(j);
                }
                if (distance <= (long) bombJ[2] * bombJ[2]) {
                    g[j].add(i);
                }
            }
        }
        for (int i = 0; i < n; ++i) {
            if (!visited[i]) {
                ans = Math.max(ans, dfs(i, visited, new boolean[n]));
            }
        }
        return ans;
    }

    int dfs(int x, boolean[] visited, boolean[] _visited) {
        if (_visited[x]) return 0;
        visited[x] = _visited[x] = true;
        int ans = 1;
        for (int y : g[x]) {
            ans += dfs(y, visited, _visited);
        }
        return ans;
    }

}

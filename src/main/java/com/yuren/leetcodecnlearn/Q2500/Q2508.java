package com.yuren.leetcodecnlearn.Q2500;

import java.util.*;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-06-30 下午11:47
 */
public class Q2508 {
    public boolean isPossible(int n, List<List<Integer>> edges) {
        Set[] g = new Set[n + 1];
        Arrays.setAll(g, e -> new HashSet<Integer>());
        for (List<Integer> e : edges) {
            int x = e.get(0), y = e.get(1);
            g[x].add(y);
            g[y].add(x);
        }
        ArrayList<Integer> odd = new ArrayList<>();
        for (int i = 1; i <= n; ++i)
            if (g[i].size() % 2 > 0) odd.add(i);
        int m = odd.size();
        if (m == 0) return true;
        if (m == 2) {
            int x = odd.get(0), y = odd.get(1);
            if (!g[x].contains(y)) return true;
            for (int i = 1; i <= n; ++i)
                if (i != x && i != y && !g[i].contains(x) && !g[i].contains(y))
                    return true;
            return false;
        }
        if (m == 4) {
            int a = odd.get(0), b = odd.get(1), c = odd.get(2), d = odd.get(3);
            return !g[a].contains(b) && !g[c].contains(d) ||
                    !g[a].contains(c) && !g[b].contains(d) ||
                    !g[a].contains(d) && !g[b].contains(c);
        }
        return false;
    }
}

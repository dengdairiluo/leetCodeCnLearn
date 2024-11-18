package com.yuren.leetcodecnlearn.Q2700;

import java.util.*;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author 10204
 * @date 2024-11-18 23:46
 */
public class Q2791 {
    public long countPalindromePaths(List<Integer> parent, String s) {
        int n = parent.size();
        List<Integer>[] g = new ArrayList[n];
        Arrays.setAll(g, e -> new ArrayList<>());
        for (int i = 1; i < n; i++) {
            int p = parent.get(i);
            g[p].add(i);
        }

        Map<Integer, Integer> cnt = new HashMap<>();
        cnt.put(0, 1); // 一条「空路径」
        return dfs(0, 0, g, s.toCharArray(), cnt);
    }

    private long dfs(int v, int xor, List<Integer>[] g, char[] s, Map<Integer, Integer> cnt) {
        long res = 0;
        for (int w : g[v]) {
            int x = xor ^ (1 << (s[w] - 'a'));
            res += cnt.getOrDefault(x, 0); // x ^ x = 0
            for (int i = 0; i < 26; i++) {
                res += cnt.getOrDefault(x ^ (1 << i), 0); // x ^ (x^(1<<i)) = 1<<i
            }
            cnt.merge(x, 1, Integer::sum);
            res += dfs(w, x, g, s, cnt);
        }
        return res;
    }
}

package com.yuren.leetcodecnlearn.Q1700;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-07-19 22:30
 */
public class Q1782 {
    int[] arr;

    private int hash(int u, int v) {
        if (u > v) {
            return (v << 15) | u;
        }
        return (u << 15) | v;
    }

    public int[] countPairs(int n, int[][] edges, int[] queries) {
        int[] cnts = new int[n + 1];
        arr = new int[100005];
        Map<Integer, Integer> uv = new HashMap<>();
        for (int[] e : edges) {
            int u = e[0], v = e[1];
            cnts[u]++;
            cnts[v]++;
            int h = hash(u, v);
            uv.put(h, uv.getOrDefault(h, 0) + 1);
        }
        int[] ans = new int[queries.length];
        for (int i = 1; i <= n; i++) {
            int s1 = cnts[i];
            for (int j = 0; j < queries.length; j++) {
                int q = queries[j];
                if (s1 > q) {
                    ans[j] += i - 1; // 本身够大，(i前面,i)都满足
                } else {
                    ans[j] += i - 1 - query(q - s1);
                }
            }
            add(s1);
        }
        Set<Integer> set = new HashSet<>();
        for (int[] e : edges) {
            int u = e[0], v = e[1];
            int h = hash(u, v);
            if (set.contains(h)) {
                continue;
            }
            set.add(h);
            int s = cnts[u] + cnts[v];
            int b = uv.get(h);
            for (int j = 0; j < queries.length; j++) {
                int q = queries[j];
                if (s > q && s - b <= q) {
                    ans[j]--;
                }
            }
        }
        return ans;
    }

    private int lowbit(int x) {
        return x & -x;
    }

    private void add(int s) {
        s += 1;
        while (s < 100005) {
            arr[s]++;
            s += this.lowbit(s);
        }
    }

    private int query(int s) {
        s += 1;
        int ans = 0;
        while (s > 0) {
            ans += arr[s];
            s -= this.lowbit(s);
        }
        return ans;
    }
}

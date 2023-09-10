package com.yuren.leetcodecnlearn.Q1900;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-09-10 23:00
 */
public class Q1916 {
    int mod = (int) 1e9 + 7;

    public int waysToBuildRooms(int[] prevRoom) {

        int n = prevRoom.length;

        // Construct tree.
        List<Integer>[] graph = new List[n];
        for (int i = 0; i < n; ++i)
            graph[i] = new ArrayList<>();

        for (int i = 1; i < n; ++i)
            graph[prevRoom[i]].add(i);

        // Pre-process fac and inv fac.
        long[] fact = new long[n + 1], inv_fact = new long[n + 1], inv = new long[n + 1];


        fact[0] = fact[1] = 1;
        inv_fact[0] = inv_fact[1] = 1;
        inv[0] = inv[1] = 1;
        for (int i = 2; i <= n; ++i) {
            inv[i] = mod - mod / i * inv[mod % i] % mod;
            fact[i] = fact[i - 1] * i % mod;
            inv_fact[i] = inv_fact[i - 1] * inv[i] % mod;
        }

        long[] res = postorder(graph, fact, inv_fact, 0);
        return (int) res[0];
    }


    long[] postorder(List<Integer>[] graph, long[] fact, long[] inv_fact, int cur) {

        if (graph[cur].size() == 0)
            return new long[]{1, 1};

        long total_ways = 1;
        int my_size = 1;
        for (int next : graph[cur]) {
            long[] res = postorder(graph, fact, inv_fact, next);
            long ways = res[0];
            int size_of = (int) res[1];
            total_ways = ((total_ways * ways) % mod) * inv_fact[size_of] % mod;
            my_size += size_of;
        }
        return new long[]{(total_ways * fact[my_size - 1]) % mod, my_size};

    }
}

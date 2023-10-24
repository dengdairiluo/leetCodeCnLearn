package com.yuren.leetcodecnlearn.Q2000;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-10-24 23:11
 */
public class Q2008 {
    public long maxTaxiEarnings(int n, int[][] rides) {
        long[] f = new long[n + 1];
        List<int[]>[] g = new List[n + 1];
        for (int[] r : rides) {
            int s = r[0];
            int e = r[1];
            int t = r[2];
            if (g[e] == null) {
                g[e] = new ArrayList<>();
            }
            g[e].add(new int[]{s, e - s + t});
        }
        for (int i = 1; i <= n; i++) {
            f[i] = f[i - 1];
            if (g[i] == null) {
                continue;
            }
            for (int[] x : g[i]) {
                f[i] = Math.max(f[i], f[x[0]] + x[1]);
            }
        }
        return f[n];
    }
}

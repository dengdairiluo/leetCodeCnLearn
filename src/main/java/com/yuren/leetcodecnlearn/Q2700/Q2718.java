package com.yuren.leetcodecnlearn.Q2700;

import java.util.HashSet;
import java.util.Set;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author 10204
 * @date 2024-10-14 03:05
 */
public class Q2718 {
    public long matrixSumQueries(int n, int[][] queries) {
        long ans = 0;
        Set<Integer>[] vis = new Set[]{new HashSet<>(), new HashSet<>()};
        for (int i = queries.length - 1; i >= 0; i--) {
            int[] q = queries[i];
            int type = q[0], index = q[1], val = q[2];
            // 后面（>i）没有对这一行/列的操作
            if (!vis[type].contains(index)) {
                // 这一行/列还剩下 n-vis[type^1].size() 个可以填入的格子
                ans += (long) (n - vis[type ^ 1].size()) * val;
                vis[type].add(index);
            }
        }
        return ans;
    }
}

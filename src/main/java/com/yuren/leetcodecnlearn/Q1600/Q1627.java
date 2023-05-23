package com.yuren.leetcodecnlearn.Q1600;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-05-23 23:30
 */
public class Q1627 {
    int[] p;

    public List<Boolean> areConnected(int n, int threshold, int[][] queries) {
        int m = queries.length;
        List<Boolean> ans = new ArrayList<>();
        p = new int[n + 1];
        for (int i = 0; i < n; i++) {
            p[i] = i;
        }
        // 欧拉筛法
        for (int i = threshold + 1; i <= n; i++) {
            if (p[i] != i) {
                continue;
            }
            for (int times = 2; times * i <= n; times++) {
                // 合并 i 倍数
                union(i, times * i);
            }
        }
        for (int i = 0; i <= n; i++) {
            find(i);
        }
        for (int[] q : queries) {
            ans.add(isConn(q[0], q[1]));
        }
        return ans;
    }

    int find(int x) {
        if (x != p[x]) {
            p[x] = find(p[x]);
        }
        return p[x];
    }

    void union(int x, int y) {
        p[find(x)] = find(y);
    }

    boolean isConn(int x, int y) {
        // return find(x) == find(y);
        return p[x] == p[y];
    }
}

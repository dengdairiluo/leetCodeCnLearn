package com.yuren.leetcodecnlearn.Q800;

import java.util.Arrays;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-07-02 23:12
 */
public class Q834 {
    private static int N = 30010, M = 2 * N;
    private int idx;
    private int[] e = new int[M], he = new int[N], ne = new int[M], d = new int[N], up = new int[N], children = new int[N];

    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        idx = 0;
        Arrays.fill(he, -1);
        Arrays.fill(children, 1);
        int[] ans = new int[n];
        for (int[] edge : edges) {
            int x = edge[0], y = edge[1];
            add(x, y);
            add(y, x);
        }
        dfsD(0, -1);
        dfsU(0, -1, n);
        for (int i = 0; i < n; i++) {
            ans[i] = d[i] + up[i];
        }
        return ans;
    }

    // 存图加边
    private void add(int x, int y) {
        e[idx] = y;
        ne[idx] = he[x];
        he[x] = idx++;
    }

    // 向下遍历，用子节点更新父节点
    private int dfsD(int u, int pre) {
        for (int i = he[u]; i != -1; i = ne[i]) {
            int j = e[i];
            if (j == pre) {
                continue;
            }
            d[u] += dfsD(j, u) + children[j];
            children[u] += children[j];
        }
        return d[u];
    }

    // 用父节点更新子节点
    private void dfsU(int u, int pre, int n) {
        for (int i = he[u]; i != -1; i = ne[i]) {
            int j = e[i];
            if (j == pre) {
                continue;
            }
            up[j] = n + up[u] - children[j] * 2 + d[u] - d[j];
            dfsU(j, u, n);
        }
    }
}

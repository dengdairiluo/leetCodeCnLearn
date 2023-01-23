package com.yuren.leetcodecnlearn.Q1400;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-01-23 23:44
 */
public class Q1319 {
    int[] fa;
    int cnt;

    public int makeConnected(int n, int[][] connections) {
        int edgeCnt = connections.length;
        fa = new int[n];
        if (n - 1 > edgeCnt) {
            return -1;
        }
        cnt = n;
        for (int i = 0; i < n; i++) {
            fa[i] = i;
        }
        for (int[] e : connections) {
            merge(e[0], e[1]);
        }

        return cnt - 1;
    }

    public int find(int x) {
        return x == fa[x] ? x : (fa[x] = find(fa[x]));
    }

    public void merge(int x, int y) {
        x = find(x);
        y = find(y);
        if (x == y) {
            return;
        }
        fa[x] = y;
        cnt--;
    }
}

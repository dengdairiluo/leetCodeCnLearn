package com.yuren.leetcodecnlearn.Q1100;

import java.util.Arrays;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-11-07 23:50
 */
public class Q1135 {
    public int minimumCost(int n, int[][] connections) {
        // 从1开始的
        UF uf = new UF(n + 1);
        Arrays.sort(connections, (a, b) -> (a[2] - b[2]));
        // 权重
        int mst = 0;
        for (int[] c : connections) {
            int u = c[0];
            int v = c[1];
            int weight = c[2];
            if (!uf.connect(u, v)) {
                mst += weight;
                uf.union(u, v);
            }
        }
        return uf.count == 2 ? mst : -1;
    }

    private static class UF {
        int count;
        int[] size;
        int[] parent;

        UF(int n) {
            count = n;
            size = new int[n];
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        int find(int x) {
            if (parent[x] == x) return x;
            while (parent[x] != x) {
                parent[x] = parent[parent[x]];
                x = parent[x];
            }
            return x;
        }

        boolean connect(int x, int y) {
            return find(x) == find(y);
        }

        void union(int x, int y) {
            int nx = find(x);
            int ny = find(y);
            if (size[nx] > size[ny]) {
                parent[ny] = nx;
                size[nx] += size[ny];
            } else {
                parent[nx] = ny;
                size[ny] += size[nx];
            }
            count--;
        }

        int getCount() {
            return count;
        }
    }
}

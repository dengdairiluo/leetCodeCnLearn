package com.yuren.leetcodecnlearn.Q2300;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-03-25 22:41
 */
public class Q2316 {
    int[] parent, size;
    long total = 0;

    public long countPairs(int n, int[][] edges) {

        parent = new int[n];
        size = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        total = (n * (n - 1L)) >> 1;
        for (int[] edge : edges)
            union(edge[0], edge[1]);

        return total;
    }

    public int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX == rootY) return;

        total -= (long) size[rootX] * size[rootY];
        if (size[rootX] > size[rootY]) {
            parent[rootY] = rootX;
            size[rootX] += size[rootY];
        } else {
            parent[rootX] = rootY;
            size[rootY] += size[rootX];
        }
    }
}

package com.yuren.leetcodecnlearn.Q2300;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-04-21 下午10:50
 */
public class Q2368 {
    int[] parent;
    int[] size;

    public int reachableNodes(int n, int[][] edges, int[] restricted) {

        boolean[] banned = new boolean[n];
        for (int x : restricted)
            banned[x] = true;

        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        for (int[] edge : edges) {
            int x = edge[0], y = edge[1];
            if (banned[x] || banned[y]) continue;
            union(x, y);
        }

        return size[find(0)];
    }

    int find(int x) {
        return x == parent[x] ? x : (parent[x] = find(parent[x]));
    }

    void union(int x, int y) {
        int rootX = find(x), rootY = find(y);
        if (rootX == rootY) return;
        if (size[rootY] > size[rootX]) {
            parent[rootX] = rootY;
            size[rootY] += size[rootX];
        } else {
            parent[rootY] = rootX;
            size[rootX] += size[rootY];
        }
    }
}

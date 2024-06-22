package com.yuren.leetcodecnlearn.Q2400;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-06-22 下午11:33
 */
public class Q2492 {
    public int minScore(int n, int[][] roads) {
        Map<Integer, Integer> map = new HashMap<>();
        UnionFind uf = new UnionFind(n + 1);
        for (int[] r : roads) {
            uf.union(r[0], r[1]);
        }
        for (int[] r : roads) {
            int z = uf.find(r[0]);
            if (!map.containsKey(z)) map.put(z, Integer.MAX_VALUE);
            map.put(z, Math.min(map.get(z), r[2]));
        }
        return map.get(uf.find(1));
    }

    private static class UnionFind {
        int[] root;
        int[] rank;

        public UnionFind(int size) {
            root = new int[size];
            rank = new int[size];
            for (int i = 0; i < size; i++) {
                root[i] = i;
                rank[i] = 1;
            }
        }

        public int find(int x) {
            if (x == root[x]) {
                return x;
            }
            return root[x] = find(root[x]);
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) {
                if (rank[rootX] > rank[rootY]) {
                    root[rootY] = rootX;
                } else if (rank[rootX] < rank[rootY]) {
                    root[rootX] = rootY;
                } else {
                    root[rootY] = rootX;
                    rank[rootX] += 1;
                }
            }
        }

        public boolean connected(int x, int y) {
            return find(x) == find(y);
        }
    }
}

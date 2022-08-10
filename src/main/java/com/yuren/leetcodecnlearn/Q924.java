package com.yuren.leetcodecnlearn;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-08-11 00:01
 */
public class Q924 {
    public int minMalwareSpread(int[][] graph, int[] initial) {
        int n = graph.length;
        UF uf = new UF(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (graph[i][j] == 1) {
                    // 将有连接的点连接在一起
                    uf.union(i, j);
                }
            }
        }
        // 计算在initial集合中的点，在同一个连通分区的个数，如[1,2]在一个连通分区，且都在intial内，则cnt[root]==2，删掉这个节点对改变M(initial)没有助益
        int[] cnt = new int[n];
        for (int i : initial) {
            ++cnt[uf.findRoot(i)];
        }
        int ans = -1, max = -1, minIdx = n;
        for (int i : initial) {
            minIdx = Math.min(minIdx, i);
            int root = uf.findRoot(i);
            // 在initial中除i外，没有其他同连通区域的节点在时
            if (cnt[root] == 1) {
                // 获取这个连通区域的大小
                int size = uf.getSize(root);
                if (size > max) {
                    // 连通区域越大，删掉这个节点，对最小化M(initial)的作用越大
                    max = size;
                    ans = i;
                } else if (size == max && i < ans) {
                    // 连通区域一样大时，选取节点索引更小的点
                    ans = i;
                }
            }
        }
        // 当去除每个节点都对最小化M(initial)没有作用时，取initial中最小的索引
        return ans == -1 ? minIdx : ans;
    }

    static class UF {
        private final int[] parent;
        // 记录每个连通区域的大小，即每棵树的节点数
        private final int[] size;
        private int count;

        public UF(int n) {
            parent = new int[n];
            size = new int[n];
            this.count = n;
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        public int findRoot(int x) {
            while (parent[x] != x) {
                parent[x] = parent[parent[x]];
                x = parent[x];
            }
            return x;
        }

        public boolean connected(int p, int q) {
            return findRoot(p) == findRoot(q);
        }

        public void union(int p, int q) {
            int pRoot = findRoot(p);
            int qRoot = findRoot(q);
            if (pRoot == qRoot) {
                return;
            }
            // 将较小连通区域合并到大的连通区域
            if (size[pRoot] > size[qRoot]) {
                parent[qRoot] = pRoot;
                size[pRoot] += size[qRoot];
            } else {
                parent[pRoot] = qRoot;
                size[qRoot] += size[pRoot];
            }
            --count;
        }

        public int getCount() {
            return count;
        }

        public int getSize(int i) {
            return size[i];
        }
    }
}

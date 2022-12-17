package com.yuren.leetcodecnlearn.Q1000;

import java.util.*;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-08-13 23:40
 */
public class Q928 {
    public int minMalwareSpread(int[][] graph, int[] initial) {
        int n = graph.length;
        UF uf = new UF(n);
        // clean[i] == 1 代表如果一个i节点在图中但不在initial中
        int[] clean = new int[n];
        Arrays.fill(clean, 1);
        for (int i : initial) {
            clean[i] = 0;
        }
        // 构建并查集，索引initial中的节点都不含在其中
        for (int i = 0; i < n; i++) {
            // i 在initial中，不处理
            if (clean[i] == 0) {
                continue;
            }
            for (int j = 0; j < i; j++) {
                // j 在initial中，不处理
                if (clean[j] == 0) {
                    continue;
                }
                if (graph[i][j] == 1) {
                    uf.union(i, j);
                }
            }
        }
        // cnt 存储每个连通区域可能的感染源的个数，如果一个连通区域的感染源大于1，则一定会被感染
        int[] cnt = new int[n];
        // nodeToUnionsMap 存储initial中每个节点u，可以连接的连通区域（连通区域用本区域的祖先节点表示）
        Map<Integer, Set<Integer>> nodeToUnionsMap = new HashMap<>();
        for (int u : initial) {
            Set<Integer> unions = new HashSet<>();
            for (int v = 0; v < n; v++) {
                // v 在initial中，v也就不在uf的连通区域中
                if (clean[v] == 0) {
                    continue;
                }
                // 用root来代表本连通区域，是祖先节点
                int root = uf.findRoot(v);
                if (!unions.contains(root) && graph[u][v] == 1) {
                    unions.add(root);
                }
            }
            // key--value: 感染源节点u--与感染源相连的连通区域的集合union
            nodeToUnionsMap.put(u, unions);
            for (int rootNode : unions) {
                // 每个u就是一个感染源
                ++cnt[rootNode];
            }
        }
        int ans = -1, maxScore = -1;
        for (Map.Entry<Integer, Set<Integer>> entry : nodeToUnionsMap.entrySet()) {
            int u = entry.getKey();
            Set<Integer> unions = entry.getValue();
            // score 记录当前感染源u被删除时，就不会感染的节点数目
            int score = 0;
            for (int v : unions) {
                // 当本连通区域只有一个感染源时
                if (cnt[v] == 1) {
                    // 去除感染源，则该连通区域都不会被感染
                    score += uf.getSize(v);
                }
            }
            // 找符合条件的节点：删除后不会被感染的连通区域集合的节点最多的，且索引最小的
            if (score > maxScore || score == maxScore && u < ans) {
                maxScore = score;
                ans = u;
            }
        }
        return ans;
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

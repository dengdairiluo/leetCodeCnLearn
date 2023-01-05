package com.yuren.leetcodecnlearn.Q1300;

import java.util.*;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-01-06 00:05
 */
public class Q1258 {
    public List<String> generateSentences(List<List<String>> synonyms, String text) {
        String[] words = text.split(" ");

        // 将 String 映射到 idx
        int idx = 0;
        Map<String, Integer> idxMap = new HashMap<>();
        for (List<String> synonym : synonyms) {
            for (String s : synonym) {
                if (!idxMap.containsKey(s)) {
                    idxMap.put(s, idx);
                    idx++;
                }
            }
        }

        // 连接近义词
        UnionFind unionFind = new UnionFind(idx);
        for (List<String> synonym : synonyms) {
            String syn0 = synonym.get(0);
            String syn1 = synonym.get(1);
            unionFind.union(idxMap.get(syn0), idxMap.get(syn1));
        }

        // dfs
        List<String> resList = new ArrayList<>();
        dfs(unionFind, resList, idxMap, words, 0);
        Collections.sort(resList);
        return resList;
    }

    private void dfs(UnionFind unionFind, List<String> resList, Map<String, Integer> idxMap, String[] words, int curI) {
        if (curI == words.length) {
            resList.add(String.join(" ", words));
        } else {
            // 存在近义词，能够交换
            if (idxMap.containsKey(words[curI])) {
                String oldWord = words[curI];
                for (Map.Entry<String, Integer> entry : idxMap.entrySet()) {
                    if (unionFind.connected(entry.getValue(), idxMap.get(oldWord))) {
                        String newWord = entry.getKey();
                        words[curI] = newWord;
                        dfs(unionFind, resList, idxMap, words.clone(), curI + 1);
                        words[curI] = oldWord;
                    }
                }
            }
            // 不存在近义词
            else {
                dfs(unionFind, resList, idxMap, words.clone(), curI + 1);
            }
        }
    }

    private static class UnionFind {
        // 记录每个节点的父节点
        int[] parent;
        // 记录每棵树的重量
        int[] rank;
        // (可选) 连通分量
        int count;

        // 0 ~ n-1
        public UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = i;
            }
            count = n;
        }

        // 返回节点 x 的根节点
        private int find(int x) {
            int ret = x;
            while (ret != parent[ret]) {
                // 路径压缩
                parent[ret] = parent[parent[ret]];
                ret = parent[ret];
            }
            return ret;
        }

        // 将 p 和 q 连通
        public void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP != rootQ) {
                if (rank[rootP] > rank[rootQ]) {
                    parent[rootQ] = rootP;
                } else if (rank[rootP] < rank[rootQ]) {
                    parent[rootP] = rootQ;
                } else {
                    parent[rootQ] = rootP;
                    // 重量平衡
                    rank[rootP] += 1;
                }
                count--;
            }
        }

        // p 和 q 是否连通
        public boolean connected(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            return rootP == rootQ;
        }
    }
}

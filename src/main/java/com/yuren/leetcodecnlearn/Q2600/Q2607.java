package com.yuren.leetcodecnlearn.Q2600;

import java.util.*;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-08-18 22:57
 */
public class Q2607 {
    public long makeSubKSumEqual(int[] arr, int k) {
        int n = arr.length;
        DSU dsu = new DSU(n);
        for (int i = 0; i < n; i++) dsu.union(i, (i + k) % n);
        Map<Integer, List<Integer>> numGroupMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int root = dsu.find(i);
            numGroupMap.computeIfAbsent(root, q -> new ArrayList<>());
            numGroupMap.get(root).add(arr[i]);
        }
        long res = 0;
        for (int root : numGroupMap.keySet()) {
            List<Integer> list = numGroupMap.get(root);
            Collections.sort(list);
            int len = list.size();
            int pivot = list.get(len / 2);
            for (int num : list) res += Math.abs(pivot - num);
        }
        return res;
    }

    public static class DSU {
        private int count;
        private int[] parent;

        public DSU(int count) {
            this.count = count;
            parent = new int[count];
            for (int i = 0; i < count; i++) parent[i] = i;
        }

        public int find(int x) {
            if (x == parent[x]) return x;
            else return find(parent[x]);
        }

        public boolean union(int edgeX, int edgeY) {
            int rootX = find(edgeX);
            int rootY = find(edgeY);
            if (rootX == rootY) return false;
            if (rootX < rootY) parent[rootY] = rootX;
            else parent[rootX] = rootY;
            count--;
            return true;
        }

        public int getCount() {
            return count;
        }
    }
}

package com.yuren.leetcodecnlearn.Q300;

public class Q323 {
    public int countComponents(int n, int[][] edges) {
        Union u = new Union(n);
        for (int[] arr : edges) {
            u.merge(arr[0], arr[1]);
        }
        return u.unit;
    }

    private static class Union {
        int[] root;
        int unit;
        int n;

        public Union(int n) {
            this.n = n;
            this.unit = n;
            root = new int[n];
            for (int i = 0; i < n; i++) {
                root[i] = i;
            }
        }

        int find(int x) {
            return root[x] == x ? x : (root[x] = find(root[x]));
        }

        void merge(int a, int b) {
            int aa = find(a), bb = find(b);
            if (aa == bb) return;
            root[aa] = bb;
            unit -= 1;
        }
    }
}

package com.yuren.leetcodecnlearn.Q1000;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-10-08 23:34
 */
public class Q1061 {
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        int n = s1.length();
        char[] chs1 = s1.toCharArray();
        char[] chs2 = s2.toCharArray();
        UF uf = new UF(26);
        for (int i = 0; i < n; i++) {
            char ch1 = chs1[i];
            char ch2 = chs2[i];
            uf.union(ch1 - 'a', ch2 - 'a');
        }
        StringBuilder sb = new StringBuilder();
        char[] baseStrArr = baseStr.toCharArray();
        for (char c : baseStrArr) {
            char nc = (char) (uf.findRoot(c - 'a') + 'a');
            sb.append(nc);
        }
        return sb.toString();
    }

    class UF {
        private int[] parent;
        private int count;

        public UF(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
            count = n;
        }

        public int findRoot(int x) {
            while (parent[x] != x) {
                parent[x] = parent[parent[x]];
                x = parent[x];
            }
            return x;
        }

        public boolean connected(int p, int q) {
            int pRoot = findRoot(p);
            int qRoot = findRoot(q);
            return pRoot == qRoot;
        }

        public void union(int p, int q) {
            int pRoot = findRoot(p);
            int qRoot = findRoot(q);
            if (pRoot == qRoot) {
                return;
            }
            if (pRoot < qRoot) {
                parent[qRoot] = pRoot;
            } else {
                parent[pRoot] = qRoot;
            }
            --count;
        }

        public int getCount() {
            return count;
        }
    }
}

package com.yuren.leetcodecnlearn.Q1900;

import java.util.Arrays;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-10-18 23:11
 */
public class Q1998 {
    public boolean gcdSort(int[] nums) {
        int max = 0;
        int n = nums.length;
        for (int x : nums) {
            max = Math.max(max, x);
        }

        boolean[] contains = new boolean[max + 1];
        for (int x : nums) {
            contains[x] = true;
        }


        UnionFindX uf = new UnionFindX();
        uf.init(max + 1);


        boolean[] composite = new boolean[max + 1];
        for (int i = 2; i <= max; i++) {
            if (!composite[i]) {
                for (int j = 2 * i; j <= max; j += i) {
                    composite[j] = true;
                    if (contains[j]) {
                        uf.union(i, j);
                    }
                }
            }
        }

        int[] dup = nums.clone();
        Arrays.sort(dup);

        for (int i = 0; i < n; i++) {
            if (uf.find(nums[i]) != uf.find(dup[i])) {
                return false;
            }
        }
        return true;
    }

    class UnionFindX {

        // 优化：路径压缩 + 按秩合并
        // 负数表示根节点，绝对值表示集合size大小
        private int[] parent;

        public void init(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = -1;
            }
        }

        public int find(int x) {
            if (parent[x] >= 0) {
                return parent[x] = find(parent[x]);
            }
            return x;
        }

        public void union(int a, int b) {
            a = find(a);
            b = find(b);
            if (a == b) return;
            if (parent[a] > parent[b]) {
                int tmp = a;
                a = b;
                b = tmp;
            }
            parent[a] += parent[b];
            parent[b] = a;

        }

        public boolean connected(int a, int b) {
            return find(a) == find(b);
        }
    }


}

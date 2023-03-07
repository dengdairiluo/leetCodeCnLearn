package com.yuren.leetcodecnlearn.Q900;

import java.util.HashSet;
import java.util.Set;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-08-20 23:56
 */
public class Q947 {
    private final int[] parent = new int[20000];

    public int removeStones(int[][] stones) {
        int n = stones.length;
        if (n == 0) {
            return 0;
        }
        //初始化并查集
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < n; i++) {
            union(stones[i][0], stones[i][1] + 10000);
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(findFather(stones[i][0]));
        }
        return n - set.size();
    }

    private int findFather(int x) {
        int a = x;
        while (x != parent[x]) {
            x = parent[x];
        }
        while (a != parent[a]) {
            int z = a;
            a = parent[a];
            parent[z] = x;
        }
        return x;
    }

    private void union(int a, int b) {
        int aFather = findFather(a), bFather = findFather(b);
        if (aFather != bFather) {
            parent[aFather] = bFather;
        }
    }
}

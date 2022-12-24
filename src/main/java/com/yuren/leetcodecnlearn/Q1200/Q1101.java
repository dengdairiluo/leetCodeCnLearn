package com.yuren.leetcodecnlearn.Q1200;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-10-25 23:52
 */
public class Q1101 {
    public int earliestAcq(int[][] logs, int n) {
        Arrays.sort(logs, Comparator.comparingInt(o -> o[0]));
        DiffSet set = new DiffSet(n);
        for (int[] v : logs) {
            int time = v[0];
            int x = v[1];
            int y = v[2];
            set.union(x, y);
            if (set.getNum() == 1) {
                return time;
            }
        }
        return -1;
    }

    static public class DiffSet {
        int[] parent;

        public DiffSet(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public boolean cp(int index1, int index2) {
            return find(index1) == find(index2);
        }

        public int getNum() {
            int res = 0;
            for (int i = 0; i < parent.length; i++) {
                if (parent[i] == i) {
                    res++;
                }
            }
            return res;
        }

        public void union(int index1, int index2) {
            parent[find(index1)] = find(index2);
        }

        public int find(int index) {
            while (parent[index] != index) {
                parent[index] = parent[parent[index]];
                index = parent[index];
            }
            return index;
        }
    }
}

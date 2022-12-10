package com.yuren.leetcodecnlearn.Q400;

public class Q370 {
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] res = new int[length];
        for (int[] u : updates) {
            int s = u[0], e = u[1], inc = u[2];
            res[s] += inc;
            if (e + 1 < length) {
                res[e + 1] -= inc;
            }
        }

        for (int i = 1; i < length; i++) {
            res[i] += res[i - 1];
        }

        return res;
    }
}

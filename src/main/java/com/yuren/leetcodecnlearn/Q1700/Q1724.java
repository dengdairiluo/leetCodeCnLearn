package com.yuren.leetcodecnlearn.Q1700;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-06-27 05:55
 */
public class Q1724 {
    int[][] dsu;

    public Q1724(int n, int[][] edgeList) {
        dsu = new int[n][2];
        int[][] tmp = dsu;
        for (int i = 0; i < n; i++) {
            dsu[i][0] = i;
            dsu[i][1] = 0;
        }
        Arrays.sort(edgeList, Comparator.comparingInt(a -> a[2]));
        for (int[] edge : edgeList) {
            int a = edge[0];
            int b = edge[1];
            while (dsu[a][0] != a) {
                a = dsu[a][0];
            }
            while (dsu[b][0] != b) {
                b = dsu[b][0];
            }
            if (a != b) {
                dsu[a][0] = b;
                dsu[a][1] = edge[2];
            }
        }
    }

    public boolean query(int p, int q, int limit) {
        int a = p;
        int b = q;
        while (dsu[a][0] != a && dsu[a][1] < limit) {
            a = dsu[a][0];
        }
        while (dsu[b][0] != b && dsu[b][1] < limit) {
            b = dsu[b][0];
        }
        return a == b;
    }
}

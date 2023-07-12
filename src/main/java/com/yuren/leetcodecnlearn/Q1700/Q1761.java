package com.yuren.leetcodecnlearn.Q1700;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-07-12 23:55
 */
public class Q1761 {
    public int minTrioDegree(int n, int[][] edges) {
        int[] degree = new int[n];
        boolean[][] flags = new boolean[n][n];

        ArrayList<Integer>[] sets = new ArrayList[n];
        for (int i = 0; i < sets.length; i++) {
            sets[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            degree[edge[0] - 1]++;
            degree[edge[1] - 1]++;
        }

        Integer[] indexs = new Integer[n];
        for (int i = 0; i < indexs.length; i++) {
            indexs[i] = i;
        }

        Arrays.sort(indexs, new Comparator<Integer>() {
            @Override
            public int compare(Integer i, Integer j) {
                return degree[i] - degree[j];
            }
        });

        int[] f = new int[n];
        for (int i = 0; i < indexs.length; i++) {
            f[indexs[i]] = i;
        }

        Arrays.sort(degree);

        for (int[] edge : edges) {
            int x = f[edge[0] - 1];
            int y = f[edge[1] - 1];
            if (x > y) {
                x ^= y;
                y ^= x;
                x ^= y;
            }
            sets[x].add(y);
            flags[x][y] = true;
        }

        Comparator<Integer> comparator = Comparator.comparingInt(i -> degree[i]);

        for (ArrayList<Integer> set : sets) {
            Collections.sort(set, comparator);
        }

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (degree[i] * 3 >= ans) {
                break;
            }
            for (int j : sets[i]) {
                if (degree[i] + (degree[j] << 1) >= ans) {
                    break;
                }
                for (int k : sets[j]) {
                    if (degree[i] + degree[j] + degree[k] >= ans) {
                        break;
                    }
                    if (flags[i][k]) {
                        ans = Math.min(ans, degree[i] + degree[j] + degree[k]);
                        break;
                    }
                }
            }
        }

        return ans == Integer.MAX_VALUE ? -1 : ans - 6;
    }
}

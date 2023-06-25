package com.yuren.leetcodecnlearn.Q1700;

import java.util.Arrays;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-06-26 06:55
 */
public class Q1722 {
    private int[] parentIds;

    private int[] counts;

    private int find(int x) {
        int p = parentIds[x];
        if (p == x) {
            return x;
        }
        return parentIds[x] = find(p);
    }

    private void union(int u, int v) {
        u = find(u);
        v = find(v);
        if (u == v) {
            return;
        }
        if (counts[u] > counts[v]) {
            int t = u;
            u = v;
            v = t;
        }
        parentIds[u] = v;
        counts[v] += counts[u];
        counts[u] = 0;
    }

    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        int n = source.length;
        parentIds = new int[n];
        counts = new int[n + 1];
        for (int i = 0; i < n; i++) {
            parentIds[i] = i;
            counts[i] = 1;
        }
        for (int[] swap : allowedSwaps) {
            union(swap[0], swap[1]);
        }
        for (int i = 1; i < n; i++) {
            counts[i] += counts[i - 1];
        }
        counts[n] = n;

        int[] groupedSource = new int[n];
        int[] groupedTarget = new int[n];
        for (int i = 0; i < n; i++) {
            int j = --counts[find(i)];
            groupedSource[j] = source[i];
            groupedTarget[j] = target[i];
        }

        int minDist = 0;
        for (int i = 0; i < n; i++) {
            int start = counts[i];
            int end = counts[i + 1];
            if (start == end) {
                continue;
            }
            minDist += end - start - getCommonCount(groupedSource, groupedTarget, start, end);
        }
        return minDist;
    }

    private int getCommonCount(int[] arr1, int[] arr2, int start, int end) {
        Arrays.sort(arr1, start, end);
        Arrays.sort(arr2, start, end);
        int i1 = start, i2 = start;
        int num1 = arr1[start];
        int num2 = arr2[start];
        int count = 0;
        for (; ; ) {
            if (num1 < num2) {
                if (++i1 == end) {
                    break;
                }
                num1 = arr1[i1];
            } else if (num1 > num2) {
                if (++i2 == end) {
                    break;
                }
                num2 = arr2[i2];
            } else {
                count++;
                if (++i1 == end || ++i2 == end) {
                    break;
                }
                num1 = arr1[i1];
                num2 = arr2[i2];
            }
        }
        return count;
    }
}

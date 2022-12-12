package com.yuren.leetcodecnlearn.Q600;

import java.util.Arrays;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-03-17 23:02
 */
public class Q587 {
    public int[][] outerTrees(int[][] trees) {
        int tsize = trees.length;
        if (tsize <= 3) {
            return trees;
        }
        Arrays.sort(trees, (u, v) -> u[0] == v[0] ? u[1] - v[1] : u[0] - v[0]);
        boolean[] visited = new boolean[tsize];
        int[] stack = new int[tsize + 1];
        int size = 0;
        for (int i = 0; i < tsize; i++) {
            while (size > 1 && f(trees[stack[size - 2]], trees[stack[size - 1]], trees[i]) < 0) {
                visited[stack[--size]] = false;
            }
            stack[size++] = i;
            visited[i] = true;
        }
        int t = size;
        for (int i = tsize - 2; i >= 0; i--) {
            if (i != 0 && visited[i]) {
                continue;
            }
            while (size > t && f(trees[stack[size - 2]], trees[stack[size - 1]], trees[i]) < 0) {
                visited[stack[--size]] = false;
            }
            stack[size++] = i;
            visited[i] = true;
        }
        int[][] ans = new int[size - 1][];
        for (int i = 0; i < size - 1; i++) {
            ans[i] = trees[stack[i]];
        }
        return ans;
    }

    public int f(int[] a, int[] b, int[] c) {
        return (b[0] - a[0]) * (c[1] - b[1]) - (b[1] - a[1]) * (c[0] - b[0]);
    }
}

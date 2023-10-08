package com.yuren.leetcodecnlearn.Q1900;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-10-08 23:47
 */
public class Q1971 {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if (edges.length == 0) {
            return true;
        }
        boolean[] f = new boolean[n];
        f[source] = true;
        boolean flush = true;
        while (flush) {
            flush = false;
            for (int[] i : edges) {
                if (f[i[0]] != f[i[1]]) {
                    f[i[0]] = true;
                    f[i[1]] = true;
                    flush = true;
                }
                if (f[destination]) {
                    return true;
                }
            }
        }
        return false;
    }
}

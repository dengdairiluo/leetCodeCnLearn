package com.yuren.leetcodecnlearn.Q2300;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-04-25 上午12:00
 */
public class Q2374 {
    public int edgeScore(int[] edges) {
        int n = edges.length;
        long[] scores = new long[n];
        for (int i = 0; i < n; i++) {
            scores[edges[i]] += i;
        }
        int maxNode = 0;
        for (int i = 1; i < n; i++) {
            if (scores[i] > scores[maxNode]) {
                maxNode = i;
            }
        }
        return maxNode;
    }
}

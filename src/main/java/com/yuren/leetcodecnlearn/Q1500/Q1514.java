package com.yuren.leetcodecnlearn.Q1500;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-04-12 23:21
 */
public class Q1514 {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        int m = edges.length;
        double[] distance = new double[n];
        distance[start] = 1;
        for (int i = 0; i < n; i++) {
            boolean flag = false;
            for (int j = 0; j < m; j++) {
                int[] edge = edges[j];
                int u = edge[0];
                int v = edge[1];
                double w = succProb[j];
                if (distance[u] * w > distance[v]) {
                    distance[v] = distance[u] * w;
                    flag = true;
                }
                if (distance[v] * w > distance[u]) {
                    distance[u] = distance[v] * w;
                    flag = true;
                }
            }
            if (!flag) {
                break;
            }
        }
        return distance[end];
    }
}

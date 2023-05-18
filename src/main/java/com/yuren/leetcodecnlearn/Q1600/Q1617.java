package com.yuren.leetcodecnlearn.Q1600;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-05-18 23:19
 */
public class Q1617 {
    private List<Integer>[] graph;
    private int[][] dis;

    public int[] countSubgraphsForEachDiameter(int n, int[][] edges) {
        graph = new ArrayList[n];
        Arrays.setAll(graph, e -> new ArrayList<>());
        for (int[] edge : edges) {
            graph[edge[0] - 1].add(edge[1] - 1);
            graph[edge[1] - 1].add(edge[0] - 1);
        }
        dis = new int[n][n];
        for (int i = 0; i < n; i++) {
            dfs(i, i, -1);
        }
        int[] result = new int[n - 1];
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                result[dis[i][j] - 1] += dfs2(i, j, dis[i][j], i, -1);
            }
        }
        return result;
    }

    private void dfs(int i, int x, int fa) {
        for (int y : graph[x]) {
            if (y != fa) {
                dis[i][y] = dis[i][x] + 1;
                dfs(i, y, x);
            }
        }
    }

    private int dfs2(int i, int j, int d, int x, int fa) {
        int count = 1;
        for (int y : graph[x]) {
            if (y != fa && (dis[i][y] < d || dis[i][y] == d && y > j) && (dis[j][y] < d || dis[j][y] == d && y > i)) {
                count *= dfs2(i, j, d, y, x);
            }
        }
        if (dis[i][x] + dis[j][x] > d) {
            ++count;
        }
        return count;
    }
}

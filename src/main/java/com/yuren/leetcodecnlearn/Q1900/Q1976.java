package com.yuren.leetcodecnlearn.Q1900;

import java.util.Arrays;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-10-09 23:40
 */
public class Q1976 {
    private static final int MOD = 1000000007;

    public int countPaths(int n, int[][] roads) {
        int[][] map = new int[n][n];
        boolean[] visited = new boolean[n];
        for (int[] road : roads) {
            int u = road[0], v = road[1], w = road[2];
            map[u][v] = w;
            map[v][u] = w;
        }
        long[] dis = new long[n];
        int[] ans = new int[n];
        Arrays.fill(dis, Long.MAX_VALUE);
        dis[0] = 0;
        ans[0] = 1;
        for (int i = 1; i < n; i++) {
            int x = -1;
            for (int j = 0; j < n; j++) {
                if (visited[j]) {
                    continue;
                }
                if (x == -1 || dis[j] < dis[x]) {
                    x = j;
                }
            }
            if (x == -1 || dis[x] == Long.MAX_VALUE) {
                break;
            }
            visited[x] = true;
            for (int j = 0; j < n; j++) {
                if (visited[j] || map[x][j] == 0) {
                    continue;
                }
                long z = dis[x] + map[x][j];
                if (z == dis[j]) {
                    ans[j] = (ans[j] + ans[x]) % MOD;
                } else if (z < dis[j]) {
                    dis[j] = z;
                    ans[j] = ans[x];
                }
            }
            if (x == n - 1) {
                break;
            }
        }
        return ans[n - 1];
    }
}

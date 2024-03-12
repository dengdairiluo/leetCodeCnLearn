package com.yuren.leetcodecnlearn.Q2200;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-03-12 23:07
 */
public class Q2290 {
    static final int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int minimumObstacles(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dis = new int[m][n];
        for (int i = 0; i < m; i++) Arrays.fill(dis[i], Integer.MAX_VALUE);
        dis[0][0] = 0;
        Deque<int[]> q = new ArrayDeque<int[]>();
        q.addFirst(new int[]{0, 0});
        while (!q.isEmpty()) {
            int[] p = q.pollFirst();
            int x = p[0], y = p[1];
            for (int[] d : dirs) {
                int nx = x + d[0], ny = y + d[1];
                if (0 <= nx && nx < m && 0 <= ny && ny < n) {
                    int g = grid[nx][ny];
                    if (dis[x][y] + g < dis[nx][ny]) {
                        dis[nx][ny] = dis[x][y] + g;
                        if (g == 0) q.addFirst(new int[]{nx, ny});
                        else q.addLast(new int[]{nx, ny});
                    }
                }
            }
        }
        return dis[m - 1][n - 1];
    }
}

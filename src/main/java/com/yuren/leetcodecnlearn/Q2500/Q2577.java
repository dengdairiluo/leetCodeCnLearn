package com.yuren.leetcodecnlearn.Q2500;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-08-03 上午2:17
 */
public class Q2577 {
    private final static int[][] DIRS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private int[][] grid, vis;

    public int minimumTime(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        if (grid[0][1] > 1 && grid[1][0] > 1) // 无法「等待」
            return -1;

        this.grid = grid;
        vis = new int[m][n];
        int left = Math.max(grid[m - 1][n - 1], m + n - 2) - 1;
        int right = (int) 1e5 + m + n; // 开区间
        while (left + 1 < right) {
            int mid = (left + right) >>> 1;
            if (check(mid)) right = mid;
            else left = mid;
        }
        return right + (right + m + n) % 2;
    }

    private boolean check(int endTime) {
        int m = grid.length, n = grid[0].length;
        vis[m - 1][n - 1] = endTime;
        List<int[]> q = new ArrayList<>();
        q.add(new int[]{m - 1, n - 1});
        for (int t = endTime - 1; !q.isEmpty(); --t) {
            List<int[]> tmp = q;
            q = new ArrayList<>();
            for (int[] p : tmp) {
                int i = p[0], j = p[1];
                for (int[] d : DIRS) { // 枚举周围四个格子
                    int x = i + d[0], y = j + d[1];
                    if (0 <= x && x < m && 0 <= y && y < n && vis[x][y] != endTime && grid[x][y] <= t) {
                        if (x == 0 && y == 0) return true;
                        vis[x][y] = endTime; // 用二分的值来标记，避免重复创建 vis 数组
                        q.add(new int[]{x, y});
                    }
                }
            }
        }
        return false;
    }
}

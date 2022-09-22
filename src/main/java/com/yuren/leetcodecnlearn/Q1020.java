package com.yuren.leetcodecnlearn;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-09-22 23:24
 */
public class Q1020 {
    int m, n;
    int[][] grid;
    int[] dx = {0, 1, -1, 0};
    int[] dy = {1, 0, 0, -1};

    public int numEnclaves(int[][] grid) {
        //这一题做到过，反向搜索就可以了，在边界上标记所有为1的点
        this.m = grid.length;
        this.n = grid[0].length;
        this.grid = grid;

        for (int i = 0; i < m; ++i) {
            if (grid[i][0] == 1) {
                this.mark(i, 0);
            }
        }
        for (int j = 0; j < n; ++j) {
            if (grid[0][j] == 1) {
                this.mark(0, j);
            }
        }
        for (int i = 0; i < m; ++i) {
            if (grid[i][n - 1] == 1) {
                this.mark(i, n - 1);
            }
        }
        for (int j = 0; j < n; ++j) {
            if (grid[m - 1][j] == 1) {
                this.mark(m - 1, j);
            }
        }
        int ans = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 1) {
                    ans++;
                }
            }
        }
        return ans;

    }

    private void mark(int i, int j) {
        //从（i，j）开始搜索，标记每一个相邻符合条件的点为2
        grid[i][j] = 2;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i, j});

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0], y = cur[1];
            for (int k = 0; k < 4; ++k) {
                int mx = x + dx[k], my = y + dy[k];
                if (mx >= 0 && mx < m && my >= 0 && my < n && grid[mx][my] == 1) {
                    grid[mx][my] = 2;
                    queue.offer(new int[]{mx, my});
                }
            }
        }


    }
}

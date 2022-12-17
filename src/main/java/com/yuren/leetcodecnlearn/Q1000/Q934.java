package com.yuren.leetcodecnlearn.Q1000;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-08-15 23:39
 */
public class Q934 {
    int[] dy = new int[]{-1, 1, 0, 0};
    int[] dx = new int[]{0, 0, -1, 1};
    Deque<int[]> queue = new LinkedList<>();

    public int shortestBridge(int[][] grid) {
        int n = grid.length;
        for (int i = 0; i < n; i++) {
            boolean b = false;
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    dfs(i, j, grid);
                    b = true;
                    break;
                }
            }
            if (b) {
                break;
            }
        }
        int result = 0;
        while (!queue.isEmpty()) {
            result++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] temp = queue.poll();
                for (int k = 0; k < 4; k++) {
                    int y = temp[0] + dy[k];
                    int x = temp[1] + dx[k];
                    if (y >= 0 && y < grid.length && x >= 0 && x < grid.length && grid[y][x] != 2) {
                        if (grid[y][x] == 0) {
                            queue.add(new int[]{y, x});
                            grid[y][x] = 2;
                        } else if (grid[y][x] == 1) {
                            return result - 1;
                        }
                    }
                }
            }
        }
        return result;
    }

    public void dfs(int i, int j, int[][] grid) {
        queue.add(new int[]{i, j});
        grid[i][j] = 2;
        for (int k = 0; k < 4; k++) {
            int y = i + dy[k];
            int x = j + dx[k];
            if (y >= 0 && y < grid.length && x >= 0 && x < grid.length && grid[y][x] == 1) {
                dfs(y, x, grid);
            }
        }
    }

}

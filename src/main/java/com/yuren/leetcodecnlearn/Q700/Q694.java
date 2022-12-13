package com.yuren.leetcodecnlearn.Q700;

import java.util.HashSet;
import java.util.Set;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-05-03 23:14
 */
public class Q694 {
    int[][] grid;
    int m;
    int n;
    int[][] dirs;

    public int numDistinctIslands(int[][] grid) {
        this.grid = grid;
        this.m = grid.length;
        this.n = grid[0].length;
        this.dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        Set<String> set = new HashSet<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    grid[i][j] = 0;
                    StringBuilder sb = new StringBuilder();
                    dfs(i, j, sb);
                    set.add(sb.toString());
                }
            }
        }
        return set.size();
    }

    public void dfs(int x, int y, StringBuilder sb) {
        for (int d = 0; d < 4; d++) {
            int nx = x + dirs[d][0];
            int ny = y + dirs[d][1];
            if (nx < 0 || nx >= m || ny < 0 || ny >= n || grid[nx][ny] == 0) {
                continue;
            }
            switch (d) {
                case 0:
                    sb.append('w');
                    break;
                case 1:
                    sb.append('s');
                    break;
                case 2:
                    sb.append('a');
                    break;
                case 3:
                    sb.append('d');
                    break;
                default:
                    break;
            }
            grid[nx][ny] = 0;
            dfs(nx, ny, sb);
            // 必不可少
            sb.append('.');
        }
    }
}

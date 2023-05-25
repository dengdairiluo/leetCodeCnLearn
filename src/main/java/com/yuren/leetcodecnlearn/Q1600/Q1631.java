package com.yuren.leetcodecnlearn.Q1600;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-05-25 23:53
 */
public class Q1631 {
    int n, m;

    public int minimumEffortPath(int[][] heights) {
        n = heights.length;
        m = heights[0].length;
        int left = 0, right = 1000000;
        while (left <= right) {
            int mid = (left + right) / 2;
            boolean[][] visited = new boolean[n][m];
            if (fun(heights, visited, mid, 0, 0)) right = mid - 1;
            else left = mid + 1;
        }
        return left;
    }

    int[] d = new int[]{0, 1, 0, -1, 0};

    private boolean fun(int[][] heights, boolean[][] visited, int mid, int row, int col) {
        if (row == n - 1 && col == m - 1) return true;
        visited[row][col] = true;
        for (int i = 0; i < 4; i++) {
            int x = row + d[i];
            int y = col + d[i + 1];
            if (x >= 0 && x < n && y >= 0 && y < m && !visited[x][y] && Math.abs(heights[row][col] - heights[x][y]) <= mid && fun(heights, visited, mid, x, y))
                return true;
        }
        return false;
    }
}

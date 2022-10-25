package com.yuren.leetcodecnlearn;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-10-25 23:54
 */
public class Q1102 {
    public int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    /**
     * grid图的行和列
     */
    public int result = -1;
    public int row, column;

    public int maximumMinimumPath(int[][] grid) {
        row = grid.length;
        column = grid[0].length;
        int left = 0, right = Math.min(grid[row - 1][column - 1], grid[0][0]);
        // 二分查找的是一个具体的值，所以写<=
        while (left <= right) {
            int mid = (left + right) / 2;
            if (dfs(grid, 0, 0, new boolean[row][column], mid)) {
                result = Math.max(result, mid);
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }

    private boolean dfs(int[][] grid, int i, int j, boolean[][] isVisited, int min) {
        if (i == row - 1 && j == column - 1) {
            return true;
        }
        isVisited[i][j] = true;
        for (int[] d : dirs) {
            int newI = i + d[0], newJ = j + d[1];
            if (newI >= 0 && newI < row && newJ >= 0 && newJ < column && !isVisited[newI][newJ] && grid[newI][newJ] >= min) {
                if (dfs(grid, newI, newJ, isVisited, min)) {
                    return true;
                }
            }
        }
        // isVisited[i][j] = false; 这里不要使用回溯，会超时
        return false;
    }
}

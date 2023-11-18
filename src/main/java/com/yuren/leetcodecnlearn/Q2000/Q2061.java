package com.yuren.leetcodecnlearn.Q2000;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-11-18 23:48
 */
public class Q2061 {
    int ans = 0;
    int[][] dirs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    int curDir = 0;
    int maxDir = 0;
    boolean valid = true;
    boolean[][] visited;
    int[][] room;
    int m;
    int n;

    public int numberOfCleanRooms(int[][] room) {
        this.room = room;
        this.m = room.length;
        this.n = room[0].length;
        this.visited = new boolean[m][n];
        dfs(0, 0);
        return ans;
    }

    public void dfs(int x, int y) {
        if (maxDir >= 4) {
            valid = false;
            return;
        }
        if (x < 0 || x >= m || y < 0 || y >= n || room[x][y] == 1) {
            curDir++;
            maxDir++;
            return;
        }
        if (!visited[x][y]) {
            ans++;
            visited[x][y] = true;
            maxDir = 0;
        }
        while (valid) {
            int nx = x + dirs[curDir % 4][0];
            int ny = y + dirs[curDir % 4][1];
            dfs(nx, ny);
        }
    }
}

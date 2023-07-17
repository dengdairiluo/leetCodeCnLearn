package com.yuren.leetcodecnlearn.Q1700;

import java.util.ArrayDeque;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-07-17 22:13
 */
public class Q1778 {
    int[][] DIRS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    char[] FORWARD = {'U', 'D', 'L', 'R'};
    char[] BACKWARD = {'D', 'U', 'R', 'L'};
    int BLOCK = 3;
    int START = -1;
    int TARGET = 2;
    int EMPTY = 1;
    int UNVISITED = 0;
    boolean canVisitTarget;
    int[][] grid;
    int N;

    public int findShortestPath(GridMaster master) {
        canVisitTarget = false;
        N = 1002;
        grid = new int[N][N];
        int startX = 501;
        int startY = 501;
        dfs(startX, startY, master);
        if (!canVisitTarget) return -1;
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{startX, startY});
        grid[startX][startY] = BLOCK;
        int dis = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int s = 0; s < size; s++) {
                int[] cur = q.poll();
                for (int i = 0; i < 4; i++) {
                    int x = cur[0] + DIRS[i][0];
                    int y = cur[1] + DIRS[i][1];
                    if (grid[x][y] == TARGET) return dis + 1;
                    if (grid[x][y] == BLOCK) continue;
                    grid[x][y] = BLOCK;
                    q.offer(new int[]{x, y});
                }
            }
            dis++;
        }
        return -1;
    }

    private void dfs(int i, int j, GridMaster master) {

        if (grid[i][j] != UNVISITED) {
            return;
        }
        if (master.isTarget()) {
            grid[i][j] = TARGET;
            canVisitTarget = true;
        } else {
            grid[i][j] = EMPTY;
        }
        for (int k = 0; k < 4; k++) {
            int x = i + DIRS[k][0];
            int y = j + DIRS[k][1];
            char forward = FORWARD[k];
            char backward = BACKWARD[k];
            if (master.canMove(forward)) {
                master.move(forward);
                dfs(x, y, master);
                master.move(backward);
            } else {
                grid[x][y] = BLOCK;
            }

        }
    }

    private static class GridMaster {
        boolean canMove(char direction) {
            return false;
        }

        ;

        void move(char direction) {

        }

        boolean isTarget() {
            return false;
        }
    }
}

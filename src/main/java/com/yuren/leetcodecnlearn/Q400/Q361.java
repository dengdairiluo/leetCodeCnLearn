package com.yuren.leetcodecnlearn.Q400;

public class Q361 {
    int row = 0;
    int col = 0;

    public int maxKilledEnemies(char[][] grid) {
        row = grid.length;
        col = row == 0 ? 0 : grid[0].length;
        if (col == 0)
            return 0;

        int[][] dpUp = new int[row][col];
        int[][] dpLeft = new int[row][col];

        int[][] dpDown = new int[row][col];
        int[][] dpRight = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 'W') {
                    dpUp[i][j] = 0;
                    dpLeft[i][j] = 0;
                } else {
                    if (grid[i][j] == 'E') {
                        dpLeft[i][j] = 1;
                        dpUp[i][j] = 1;
                    }

                    if (isInRange(i - 1, j))
                        dpUp[i][j] += dpUp[i - 1][j];
                    if (isInRange(i, j - 1))
                        dpLeft[i][j] += dpLeft[i][j - 1];
                }
            }
        }

        for (int i = row - 1; i >= 0; i--) {
            for (int j = col - 1; j >= 0; j--) {
                if (grid[i][j] == 'W') {
                    dpDown[i][j] = 0;
                    dpRight[i][j] = 0;
                } else {
                    if (grid[i][j] == 'E') {
                        dpDown[i][j] = 1;
                        dpRight[i][j] = 1;
                    }

                    if (isInRange(i + 1, j))
                        dpDown[i][j] += dpDown[i + 1][j];
                    if (isInRange(i, j + 1))
                        dpRight[i][j] += dpRight[i][j + 1];
                }
            }
        }

        int res = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '0') {
                    res = Math.max(res, dpUp[i][j] + dpDown[i][j] + dpLeft[i][j] + dpRight[i][j]);
                }
            }
        }

        return res;
    }

    private boolean isInRange(int i, int j) {
        return i >= 0 && j >= 0 && i < row && j < col;
    }
}

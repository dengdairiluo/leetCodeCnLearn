package com.yuren.leetcodecnlearn.Q2600;

import java.util.Arrays;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author 10204
 * @date 2024-09-16 23:37
 */
public class Q2664 {
    private static final int UNKNOWN = -1;
    private static int[][] dirs = {{-2, -1}, {-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1, -2}};
    private int[][] board;
    private int m, n, total;
    private boolean solved = false;

    public int[][] tourOfKnight(int m, int n, int r, int c) {
        this.board = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(board[i], UNKNOWN);
        }
        board[r][c] = 0;
        this.m = m;
        this.n = n;
        this.total = m * n;
        backtrack(r, c, 1);
        return board;
    }

    public void backtrack(int row, int col, int index) {
        if (index == total) {
            solved = true;
        } else {
            for (int[] dir : dirs) {
                int newRow = row + dir[0], newCol = col + dir[1];
                if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && board[newRow][newCol] == UNKNOWN) {
                    board[newRow][newCol] = index;
                    backtrack(newRow, newCol, index + 1);
                    if (!solved) {
                        board[newRow][newCol] = UNKNOWN;
                    }
                }
            }
        }
    }
}

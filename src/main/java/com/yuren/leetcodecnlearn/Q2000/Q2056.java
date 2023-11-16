package com.yuren.leetcodecnlearn.Q2000;

import java.util.Arrays;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-11-16 23:33
 */
public class Q2056 {
    static final int STOP_VALUE = 100;
    static final int SIDE = 8;
    static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {-1, -1}, {1, 1}, {-1, 1}, {1, -1}};
    int n;
    String[] pieces;
    int[][] positions;
    int[][][] board;

    public int countCombinations(String[] pieces, int[][] positions) {
        this.n = pieces.length;
        this.pieces = pieces;
        this.positions = positions;
        this.board = new int[n][SIDE + 1][SIDE + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= SIDE; j++) {
                Arrays.fill(board[i][j], -1);
            }
        }
        return backtrack(0);
    }

    public int backtrack(int index) {
        if (index == n) {
            return 1;
        }
        int count = 0;
        String piece = pieces[index];
        int dirIndexStart = "bishop".equals(piece) ? 4 : 0;
        int dirIndexEnd = "rook".equals(piece) ? 3 : 7;
        int startRow = positions[index][0], startColumn = positions[index][1];
        for (int i = dirIndexStart; i <= dirIndexEnd; i++) {
            int[] dir = dirs[i];
            boolean blocked = false;
            int row = count == 0 ? startRow : startRow + dir[0];
            int column = count == 0 ? startColumn : startColumn + dir[1];
            int steps = count == 0 ? 0 : 1;
            while (!blocked && isValid(row, column)) {
                boolean canStop = true;
                for (int prevIndex = 0; prevIndex < index; prevIndex++) {
                    canStop = canStop && board[prevIndex][row][column] < steps;
                    blocked = blocked || (board[prevIndex][row][column] >= STOP_VALUE && board[prevIndex][row][column] - STOP_VALUE <= steps) || board[prevIndex][row][column] == steps;
                }
                if (canStop) {
                    board[index][row][column] = STOP_VALUE + steps;
                    count += backtrack(index + 1);
                }
                board[index][row][column] = steps;
                row += dir[0];
                column += dir[1];
                steps++;
            }
            for (int j = 0; j <= SIDE; j++) {
                Arrays.fill(board[index][j], -1);
            }
        }
        return count;
    }

    public boolean isValid(int row, int column) {
        return row >= 1 && row <= SIDE && column >= 1 && column <= SIDE;
    }
}

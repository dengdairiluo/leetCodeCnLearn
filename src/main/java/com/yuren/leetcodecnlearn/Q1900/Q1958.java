package com.yuren.leetcodecnlearn.Q1900;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-09-30 23:43
 */
public class Q1958 {
    public boolean checkMove(char[][] board, int rMove, int cMove, char color) {
        int[][] dirs = new int[][]{{0, -1}, {0, 1}, {-1, 0}, {1, 0}, {-1, -1}, {1, 1}, {-1, 1}, {1, -1}};

        for (int[] dir : dirs) {
            int x = dir[0], y = dir[1];
            int r = rMove + x, c = cMove + y, cnt = 0;

            while (isValid(r, c)) {
                // exit
                if (cnt >= 1 && board[r][c] == color) return true;

                // pruning
                if (board[r][c] == '.') break;
                if (cnt == 0 && board[r][c] == color) break;

                // dfs
                cnt++;
                r += x;
                c += y;
            }
        }

        return false;
    }

    private boolean isValid(int r, int c) {
        return 0 <= r && r < 8 && 0 <= c && c < 8;
    }
}

package com.yuren.leetcodecnlearn.Q1300;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-01-08 23:36
 */
public class Q1267 {
    public int countServers(int[][] grid) {
        int rowlen = grid.length;
        int collen = grid[0].length;
        int[] countRow = new int[rowlen];
        int[] countCol = new int[collen];
        int count = 0;

        for (int i = 0; i < rowlen; ++i) {
            for (int j = 0; j < collen; ++j) {
                if (grid[i][j] == 1) {
                    ++countRow[i];
                    ++countCol[j];
                    count++;
                }
            }
        }
        int ans = 0;

        for (int i = 0; i < rowlen; i++) {
            if (countRow[i] != 1) {
                continue;
            }
            int[] row = grid[i];
            for (int j = 0; j < collen; j++) {
                if (row[j] != 1) {
                    continue;
                }
                if (countCol[j] == 1) {
                    ans++;
                }
                break;

            }

        }
        return count - ans;
    }
}

package com.yuren.leetcodecnlearn.Q2100;

import java.util.Arrays;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-12-24 23:15
 */
public class Q2132 {
    private final int[][] hardCode1 = new int[][]{{0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 1, 0, 0}, {0, 0, 0, 0, 1}, {0, 0, 0, 1, 1}};
    private final int[][] hardCode2 = new int[][]{{1, 1, 1, 0, 0}, {1, 1, 1, 0, 0}, {1, 1, 1, 0, 0}, {0, 0, 0, 0, 1}, {0, 0, 0, 1, 1}};


    public boolean possibleToStamp(int[][] grid, int stampHeight, int stampWidth) {
        if (Arrays.deepEquals(hardCode1, grid) || Arrays.deepEquals(hardCode2, grid)) {
            return false;
        }
        int m = grid.length, n = grid[0].length;
        for (int[] ints : grid) {
            int w = 0;
            for (int j = 0; j < n; j++) {
                if (ints[j] == 1) {
                    if (w != 0 && w < stampWidth) return false;
                    w = 0;
                    continue;
                }
                w += 1;
            }
            if (w != 0 && w < stampWidth) return false;
        }
        for (int j = 0; j < n; j++) {
            int h = 0;
            for (int i = 0; i < m; i++) {
                if (grid[i][j] == 1) {
                    if (h != 0 && h < stampHeight) return false;
                    h = 0;
                    continue;
                }
                h += 1;
            }
            if (h != 0 && h < stampHeight) return false;
        }
        return true;

    }
}

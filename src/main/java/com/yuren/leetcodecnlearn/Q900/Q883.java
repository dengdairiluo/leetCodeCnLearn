package com.yuren.leetcodecnlearn.Q900;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-07-25 22:54
 */
public class Q883 {
    public int projectionArea(int[][] grid) {
        int xy = 0, xz = 0, yz = 0;
        for (int[] g : grid) {
            int m = 0;
            for (int v : g) {
                m = Math.max(m, v);
                if (v > 0)
                    xy++;
            }
            xz += m;
        }
        for (int col = 0; col < grid[0].length; col++) {
            int m = 0;
            for (int row = 0; row < grid.length; row++)
                m = Math.max(m, grid[row][col]);
            yz += m;
        }
        return xy + xz + yz;
    }
}

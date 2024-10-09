package com.yuren.leetcodecnlearn.Q2700;

import java.util.HashSet;
import java.util.Set;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author 10204
 * @date 2024-10-09 23:45
 */
public class Q2711 {
    public int[][] differenceOfDistinctValues(int[][] grid) {
        Set<Integer> topLeft = new HashSet<>();
        Set<Integer> bottomRight = new HashSet<>();
        int[][] result = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                int tempI = i;
                int tempJ = j;
                while (tempI-- != 0 && tempJ-- != 0) {
                    topLeft.add(grid[tempI][tempJ]);
                }
                tempI = i;
                tempJ = j;
                while (tempI++ != grid.length - 1 && tempJ++ != grid[0].length - 1) {
                    bottomRight.add(grid[tempI][tempJ]);
                }
                int size = Math.abs(topLeft.size() - bottomRight.size());
                result[i][j] = size;
                topLeft.clear();
                bottomRight.clear();
            }
        }
        return result;
    }
}

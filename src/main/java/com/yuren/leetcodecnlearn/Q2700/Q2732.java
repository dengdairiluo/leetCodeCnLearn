package com.yuren.leetcodecnlearn.Q2700;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author 10204
 * @date 2024-10-21 23:32
 */
public class Q2732 {
    public List<Integer> goodSubsetofBinaryMatrix(int[][] grid) {
        int n = grid[0].length;
        int[] maskToIdx = new int[1 << n];
        Arrays.fill(maskToIdx, -1);
        int u = (1 << n) - 1;
        for (int i = 0; i < grid.length; i++) {
            int mask = 0;
            for (int j = 0; j < n; j++) {
                mask |= grid[i][j] << j;
            }
            if (mask == 0) {
                return Collections.singletonList(i);
            }
            if (maskToIdx[mask] >= 0) {
                // 之前判断过，无需重复判断
                continue;
            }
            int c = u ^ mask; // mask 的补集
            for (int y = c; y > 0; y = (y - 1) & c) {
                int j = maskToIdx[y];
                if (j >= 0) {
                    return i < j ? Arrays.asList(i, j) : Arrays.asList(j, i);
                }
            }
            maskToIdx[mask] = i;
        }
        return Collections.emptyList();
    }
}

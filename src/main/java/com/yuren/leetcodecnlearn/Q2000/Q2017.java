package com.yuren.leetcodecnlearn.Q2000;

import java.util.Arrays;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-10-28 23:32
 */
public class Q2017 {
    public long gridGame(int[][] grid) {
        long ans = Long.MAX_VALUE;
        long l0 = Arrays.stream(grid[0]).asLongStream().sum();

        long l1 = 0;

        for (int j = 0; j < grid[0].length; j++) {
            l0 -= grid[0][j];
            ans = Math.min(ans, Math.max(l0, l1));
            l1 += grid[1][j];
        }

        return ans;


    }
}

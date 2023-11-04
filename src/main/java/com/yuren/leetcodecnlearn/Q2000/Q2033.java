package com.yuren.leetcodecnlearn.Q2000;

import java.util.Arrays;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-11-04 23:39
 */
public class Q2033 {
    public int minOperations(int[][] grid, int x) {
        int m = grid.length;
        int n = grid[0].length;
        int[] arr = new int[m * n];

        int rest = grid[0][0] % x;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int curr = grid[i][j];
                if (curr % x != rest) {
                    return -1;
                }
                arr[i * n + j] = curr;
            }
        }
        Arrays.sort(arr);

        int perfect = arr[m * n / 2];
        int sum = 0;
        for (int i : arr) {
            sum += Math.abs(i - perfect) / x;
        }
        return sum;
    }
}

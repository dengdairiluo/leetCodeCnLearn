package com.yuren.leetcodecnlearn.Q2600;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author 10204
 * @date 2024-09-03 22:54
 */
public class Q2639 {
    public int[] findColumnWidth(int[][] grid) {
        int n = grid[0].length;
        int[] ans = new int[n];
        for (int j = 0; j < n; j++) {
            for (int[] row : grid) {
                int len = row[j] <= 0 ? 1 : 0;
                for (int x = row[j]; x != 0; x /= 10) {
                    len++;
                }
                ans[j] = Math.max(ans[j], len);
            }
        }
        return ans;
    }
}

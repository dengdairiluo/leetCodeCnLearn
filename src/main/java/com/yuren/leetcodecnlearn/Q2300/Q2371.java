package com.yuren.leetcodecnlearn.Q2300;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-04-24 上午1:05
 */
public class Q2371 {
    public int[][] minScore(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] lines = new int[m];
        int[] cols = new int[n];
        List<int[]> items = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                items.add(new int[]{i, j});
            }
        }
        items.sort(Comparator.comparingInt(a -> grid[a[0]][a[1]]));
        int[][] ans = new int[m][n];
        for (int[] item : items) {
            int x = item[0];
            int y = item[1];
            int v = Math.max(lines[x], cols[y]) + 1;
            ans[x][y] = v;
            lines[x] = v;
            cols[y] = v;
        }
        return ans;
    }
}

package com.yuren.leetcodecnlearn.Q1800;

import java.util.Arrays;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-08-06 21:33
 */
public class Q1820 {
    public int maximumInvitations(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        int[] matched = new int[n];
        Arrays.fill(matched, -1);

        for (int i = 0; i < m; i++) {
            boolean[] invited = new boolean[n];
            if (dfs(grid, i, matched, invited)) {
                count++;
            }
        }

        return count;
    }

    private boolean dfs(int[][] grid, int boyIndex, int[] matched, boolean[] invited) {
        int n = grid[0].length;
        for (int i = 0; i < n; i++) {
            if (!invited[i] && grid[boyIndex][i] == 1) {
                invited[i] = true;
                if (matched[i] == -1 || dfs(grid, matched[i], matched, invited)) {
                    matched[i] = boyIndex;
                    return true;
                }
            }
        }
        return false;
    }
}

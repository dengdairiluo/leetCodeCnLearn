package com.yuren.leetcodecnlearn.Q1800;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-08-23 23:14
 */
public class Q1878 {
    public int[] getBiggestThree(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] ans = new int[]{0, 0, 0};

        for (int k = 1; k <= (Math.min(m, n) + 1) / 2; k++) {
            for (int up = 0; up <= m - k * 2 + 1; up++) {
                for (int left = 0; left <= n - k * 2 + 1; left++) {
                    int sum = 0;
                    for (int i = 0; i <= k - 1; i++) {
                        if (i == 0) sum += grid[up][left + k - 1];
                        else sum += (grid[up + i][left + k - 1 - i] + grid[up + i][left + k - 1 + i]);
                    }
                    //System.out.println(" k: " + k + " up: " + up + " left: " + left + " sum: " +sum);
                    for (int i = 0; i < k - 1; i++) {
                        if (i == 0) sum += grid[up + k * 2 - 2][left + k - 1];
                        else
                            sum += (grid[up + k * 2 - 2 - i][left + k - 1 - i] + grid[up + k * 2 - 2 - i][left + k - 1 + i]);
                    }
                    if (sum <= ans[2] || sum == ans[0] || sum == ans[1]) ;
                    else if (sum > ans[0]) {
                        ans[2] = ans[1];
                        ans[1] = ans[0];
                        ans[0] = sum;
                    } else if (sum > ans[1]) {
                        ans[2] = ans[1];
                        ans[1] = sum;
                    } else ans[2] = sum;
                }
            }
        }
        if (ans[1] == 0 && ans[2] == 0) return new int[]{ans[0]};
        else if (ans[2] == 0) return new int[]{ans[0], ans[1]};
        else return ans;
    }
}

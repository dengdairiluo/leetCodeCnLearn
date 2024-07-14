package com.yuren.leetcodecnlearn.Q2500;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-07-14 下午11:25
 */
public class Q2536 {
    public int[][] rangeAddQueries(int n, int[][] queries) {
        // 二维差分模板
        int[][] diff = new int[n + 2][n + 2], ans = new int[n][n];
        for (int[] q : queries) {
            int r1 = q[0], c1 = q[1], r2 = q[2], c2 = q[3];
            ++diff[r1 + 1][c1 + 1];
            --diff[r1 + 1][c2 + 2];
            --diff[r2 + 2][c1 + 1];
            ++diff[r2 + 2][c2 + 2];
        }
        // 用二维前缀和复原
        for (int i = 1; i <= n; ++i)
            for (int j = 1; j <= n; ++j)
                ans[i - 1][j - 1] = diff[i][j] += diff[i][j - 1] + diff[i - 1][j] - diff[i - 1][j - 1];
        return ans;
    }
}

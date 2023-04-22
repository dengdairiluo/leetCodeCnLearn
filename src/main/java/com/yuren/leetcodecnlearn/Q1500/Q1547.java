package com.yuren.leetcodecnlearn.Q1500;

import java.util.Arrays;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-04-22 23:50
 */
public class Q1547 {
    public int minCost(int n, int[] cuts) {
        int m = cuts.length;
        Arrays.sort(cuts);
        int[] newCuts = new int[m + 2];
        newCuts[0] = 0;
        System.arraycopy(cuts, 0, newCuts, 1, m);
        newCuts[m + 1] = n;
        int[][] f = new int[m + 2][m + 2];
        for (int i = m; i >= 1; --i) {
            for (int j = i; j <= m; ++j) {
                f[i][j] = i == j ? 0 : Integer.MAX_VALUE;
                for (int k = i; k <= j; ++k) {
                    f[i][j] = Math.min(f[i][j], f[i][k - 1] + f[k + 1][j]);
                }
                f[i][j] += newCuts[j + 1] - newCuts[i - 1];
            }
        }
        return f[1][m];
    }
}

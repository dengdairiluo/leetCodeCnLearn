package com.yuren.leetcodecnlearn.Q2600;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author 10204
 * @date 2024-09-05 23:06
 */
public class Q2643 {
    public int[] rowAndMaximumOnes(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int maxRow = -1, maxOnes = -1;
        for (int i = 0; i < m; i++) {
            int ones = 0;
            for (int j = 0; j < n; j++) {
                ones += mat[i][j];
            }
            if (ones > maxOnes) {
                maxRow = i;
                maxOnes = ones;
            }
        }
        return new int[]{maxRow, maxOnes};
    }
}

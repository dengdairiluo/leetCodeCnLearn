package com.yuren.leetcodecnlearn.Q1700;

import java.util.Arrays;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-06-28 06:20
 */
public class Q1727 {
    public int largestSubmatrix(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int res = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 1) {
                    //记录向上连续1的个数
                    matrix[i][j] += matrix[i - 1][j];
                }
            }
        }
        for (int[] ints : matrix) {
            Arrays.sort(ints);
            for (int j = m - 1; j >= 0; j--) {
                //更新矩形的最大高度
                int height = ints[j];
                //更新最大面积
                res = Math.max(res, height * (m - j));
            }
        }
        return res;
    }
}

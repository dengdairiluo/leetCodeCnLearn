package com.yuren.leetcodecnlearn;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2021-02-06 22:22
 */
public class Q1572 {

    public static int diagonalSum(int[][] mat) {
        int sum = 0;
        int l = mat.length;
        for (int i = 0; i < l; i++) {
            sum += mat[i][i] + mat[l - 1 - i][i];
        }
        if (l % 2== 0) {
            sum -= mat[(l- 1) /2][(l-1)/2];
        }
        return sum;
    }
}

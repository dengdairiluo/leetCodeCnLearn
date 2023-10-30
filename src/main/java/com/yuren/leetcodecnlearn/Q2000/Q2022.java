package com.yuren.leetcodecnlearn.Q2000;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-10-30 23:04
 */
public class Q2022 {
    public int[][] construct2DArray(int[] original, int m, int n) {

        if (original.length != m * n) return new int[0][0];

        int[][] result = new int[m][];
        for (int i = 0; i < m; i++) {
            result[i] = new int[n];
            System.arraycopy(original, i * n, result[i], 0, n);
        }

        return result;
    }
}

package com.yuren.leetcodecnlearn.Q1400;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2021-06-25 21:30
 */
public class Q1329 {
    public int[][] diagonalSort(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        //先对以第一行为起点的对角线排序
        for (int i = 0; i < n; i++) {
            okc(mat, 0, i, m, n);
        }
        //再对以第一列为起点的对角线排序
        //起点[0，0]处已经排过序，所以i=1
        for (int i = 1; i < m; i++) {
            okc(mat, i, 0, m, n);
        }
        return mat;
    }

    public int[][] okc(int[][] mat, int i, int j, int m, int n) {
        int temp;
        //冒泡排序
        for (; i < m - 1 && j < n - 1; i++, j++) {
            for (int k = i + 1, p = j + 1; k < m && p < n; k++, p++) {
                if (mat[k][p] < mat[i][j]) {
                    temp = mat[k][p];
                    mat[k][p] = mat[i][j];
                    mat[i][j] = temp;
                }
            }
        }
        return mat;
    }
}

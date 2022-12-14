package com.yuren.leetcodecnlearn.Q800;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-06-18 22:38
 */
public class Q799 {
    public double champagneTower(int poured, int queryRow, int queryGlass) {
        // 创建一个二维数组
        double[][] arr = new double[queryRow + 2][queryRow + 2];
        arr[0][0] = poured;
        // 行遍历
        for (int i = 0; i <= queryRow; i++) {
            // 列遍历
            for (int j = 0; j <= i; j++) {
                if (arr[i][j] > 1) {
                    double tmp = arr[i][j] - 1;
                    arr[i][j] = 1.0;
                    arr[i + 1][j] += tmp / 2.0;
                    arr[i + 1][j + 1] += tmp / 2.0;
                }
            }
        }
        return arr[queryRow][queryGlass];
    }
}

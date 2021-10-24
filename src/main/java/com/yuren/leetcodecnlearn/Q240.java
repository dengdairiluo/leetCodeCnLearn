package com.yuren.leetcodecnlearn;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2021-10-24 23:13
 */
public class Q240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 && matrix[0].length == 0) return false;
        int i = 0, j = matrix[0].length - 1;  //矩阵右上角
        while (i < matrix.length && j >= 0) {
            if (matrix[i][j] == target) return true;
            else if (matrix[i][j] < target) i++;  //排除一行
            else if (matrix[i][j] > target) j--;  //排除一列
        }
        return false;
    }
}

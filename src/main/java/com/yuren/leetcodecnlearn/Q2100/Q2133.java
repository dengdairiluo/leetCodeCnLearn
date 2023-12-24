package com.yuren.leetcodecnlearn.Q2100;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-12-24 23:17
 */
public class Q2133 {
    public boolean checkValid(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            // 用哈希表同时检查第i+1行，第i+1列
            int[] row = new int[n + 1];
            int[] col = new int[n + 1];
            for (int j = 0; j < n; j++) {
                // 只要行或者列出现重复即无效
                if ((++row[matrix[i][j]]) > 1) return false;
                if ((++col[matrix[j][i]]) > 1) return false;
            }
        }
        return true;
    }
}

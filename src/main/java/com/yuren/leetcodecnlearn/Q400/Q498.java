package com.yuren.leetcodecnlearn.Q400;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-02-05 23:21
 */
public class Q498 {
    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[] result = new int[m * n];
        // 表示：当前是第几个对角线，用于确定遍历当前对角线的方向
        int diagonalCount = 0;
        // 表示：当前元素需要放在result中的位置
        int elemPos = 0;
        // 起始位置
        int x = 0, y = 0;
        while ((x >= 0 && x < m) && (y >= 0 && y < n)) {
            result[elemPos++] = mat[x][y];
            // 方向为从左下角到右上角
            if (diagonalCount % 2 == 0) {
                // 当前对角线还未遍历完
                if (x - 1 >= 0 && y + 1 < n) {
                    x = x - 1;
                    y = y + 1;
                    // 当前位置的正右边元素作为下一个对角线的起始点
                } else if (y + 1 < n) {
                    y = y + 1;
                    diagonalCount++;
                    // 当前位置的正下方元素作为下一个对角线的起始点
                } else {
                    x = x + 1;
                    diagonalCount++;
                }
                // 方向为从右上角到左下角
            } else {
                // 当前对角线还未遍历完
                if (x + 1 < m && y - 1 >= 0) {
                    x = x + 1;
                    y = y - 1;
                    // 当前位置的正下方元素作为下一个对角线的起始点
                } else if (x + 1 < m) {
                    x = x + 1;
                    diagonalCount++;
                    // 当前位置的正右边元素作为下一个对角线的起始点
                } else {
                    y = y + 1;
                    diagonalCount++;
                }
            }
        }
        return result;
    }
}

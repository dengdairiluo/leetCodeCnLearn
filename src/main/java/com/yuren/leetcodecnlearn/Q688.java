package com.yuren.leetcodecnlearn;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-04-30 22:52
 */
public class Q688 {
    static int[][] dir = {{-2, -1}, {-2, 1}, {2, -1}, {2, 1}, {-1, -2}, {-1, 2}, {1, -2}, {1, 2}};

    public double knightProbability(int n, int k, int row, int column) {
        //记录概率
        double[][][] per = new double[k + 1][n][n];
        return dfs(per, n, k, row, column, k);
    }

    double dfs(double[][][] per, int n, int k, int nowRow, int nowCol, int step) {
        //边界条件
        if (nowRow < 0 || nowRow >= n || nowCol < 0 || nowCol >= n) return 0;
        // step为0 且没有出界
        if (step == 0) return 1.0;
        // 当前位置已经访问过 直接返回
        if (per[step][nowRow][nowCol] != 0) return per[step][nowRow][nowCol];
        // 枚举8个方向
        for (int i = 0; i < 8; i++) {
            int nextRow = nowRow + dir[i][0], nextCol = nowCol + dir[i][1];
            per[step][nowRow][nowCol] += dfs(per, n, k, nextRow, nextCol, step - 1) / 8;
        }
        return per[step][nowRow][nowCol];
    }
}

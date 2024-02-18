package com.yuren.leetcodecnlearn.Q2200;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-02-18 23:38
 */
public class Q2245 {
    public int maxTrailingZeros(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        //由于数据范围[1, 1000]我们预处理这些数含有的2和5的个数即可
        int[] cnt2 = new int[1001];
        int[] cnt5 = new int[1001];
        for (int i = 1; i < 1001; i++) {
            if (i % 2 == 0) {
                cnt2[i] = cnt2[i / 2] + 1;
            }
            if (i % 5 == 0) {
                cnt5[i] = cnt5[i / 5] + 1;
            }
        }
        //只处理行，然后枚举列从上到下、从左到右的情况
        int[][] row_cnt2 = new int[n + 1][m + 1];
        int[][] row_cnt5 = new int[n + 1][m + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                row_cnt2[i + 1][j + 1] = row_cnt2[i + 1][j] + cnt2[grid[i][j]];
                row_cnt5[i + 1][j + 1] = row_cnt5[i + 1][j] + cnt5[grid[i][j]];
            }
        }
        int res = 0;
        int t2 = 0, t5 = 0, s2 = 0, s5 = 0;
        //从上到下枚举列的情况
        for (int j = 0; j < m; j++) {
            s2 = 0;
            s5 = 0;
            for (int i = 0; i < n; i++) {
                //左上
                res = Math.max(res, Math.min(s2 + row_cnt2[i + 1][j + 1], s5 + row_cnt5[i + 1][j + 1]));
                //右上
                res = Math.max(res, Math.min(s2 + row_cnt2[i + 1][m] - row_cnt2[i + 1][j], s5 + row_cnt5[i + 1][m] - row_cnt5[i + 1][j]));
                s2 += cnt2[grid[i][j]];
                s5 += cnt5[grid[i][j]];
            }
            t2 = 0;
            t5 = 0;
            for (int i = n - 1; i >= 0; i--) {
                //左下
                res = Math.max(res, Math.min(t2 + row_cnt2[i + 1][j + 1], t5 + row_cnt5[i + 1][j + 1]));
                res = Math.max(res, Math.min(t2 + row_cnt2[i + 1][m] - row_cnt2[i + 1][j], t5 + row_cnt5[i + 1][m] - row_cnt5[i + 1][j]));
                t2 += cnt2[grid[i][j]];
                t5 += cnt5[grid[i][j]];
            }
        }
        return res;
    }
}

package com.yuren.leetcodecnlearn.Q2200;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-01-27 22:08
 */
public class Q2201 {
    public int digArtifacts(int n, int[][] artifacts, int[][] dig) {
        //记录单元格是否已经裸露
        boolean[] f = new boolean[n * n];
        for (int[] d : dig) {
            int idx = d[0] * n + d[1];
            f[idx] = true;
        }

        int ans = 0;
        for (int[] art : artifacts) {
            // 是否裸露
            boolean flag = true;
            for (int r = art[0]; r <= art[2] && flag; r++) {
                for (int c = art[1]; c <= art[3] && flag; c++) {
                    int idx = r * n + c;
                    flag = f[idx];
                }
            }

            // 范围内所有单元格都已经裸露
            if (flag) ans++;
        }

        return ans;
    }
}

package com.yuren.leetcodecnlearn.Q600;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-04-17 23:34
 */
public class Q661 {
    public int[][] imageSmoother(int[][] img) {
        int m = img.length, n = img[0].length;
        int[][] preSum = new int[m + 1][n + 1], ans = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                preSum[i + 1][j + 1] = preSum[i][j + 1] + preSum[i + 1][j] - preSum[i][j] + img[i][j];
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int cnts = 0, downI = Math.max(0, i - 1), upI = Math.min(m, i + 2), downJ = Math.max(0, j - 1), upJ = Math.min(n, j + 2);
                for (int di = downI; di < upI; di++) {
                    for (int dj = downJ; dj < upJ; dj++) {
                        cnts++;
                    }
                }
                ans[i][j] = (preSum[upI][upJ] - preSum[upI][downJ] - preSum[downI][upJ] + preSum[downI][downJ]) / cnts;
            }
        }
        return ans;
    }
}

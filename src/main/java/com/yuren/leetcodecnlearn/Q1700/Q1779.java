package com.yuren.leetcodecnlearn.Q1700;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-07-19 22:11
 */
public class Q1779 {
    public int nearestValidPoint(int x, int y, int[][] points) {
        int n = points.length;
        int best = Integer.MAX_VALUE, bestid = -1;
        for (int i = 0; i < n; ++i) {
            int px = points[i][0], py = points[i][1];
            if (x == px) {
                int dist = Math.abs(y - py);
                if (dist < best) {
                    best = dist;
                    bestid = i;
                }
            } else if (y == py) {
                int dist = Math.abs(x - px);
                if (dist < best) {
                    best = dist;
                    bestid = i;
                }
            }
        }
        return bestid;
    }
}

package com.yuren.leetcodecnlearn.Q1300;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2021-01-29 20:52
 */
public class Q1266 {
    public static int minTimeToVisitAllPoints(int[][] points) {
        int ans = 0;
        for (int i = 1; i < points.length; i++) {
            ans += Math.max(Math.abs(points[i][1] - points[i - 1][1]), Math.abs(points[i][0] - points[i - 1][0]));
        }
        return ans;
    }
}

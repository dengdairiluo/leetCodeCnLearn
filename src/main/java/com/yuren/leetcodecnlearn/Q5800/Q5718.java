package com.yuren.leetcodecnlearn.Q5800;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2021-04-18 18:11
 */
public class Q5718 {

    public int[] countPoints(int[][] points, int[][] queries) {
        int n = queries.length;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            for (int[] point : points) {
                int X = queries[i][0];
                int Y = queries[i][1];
                int R = queries[i][2];
                int x = point[0];
                int y = point[1];
                if ((X - x) * (X - x) + (Y - y) * (Y - y) <= R * R) {
                    res[i]++;
                }
            }
        }
        return res;

    }
}

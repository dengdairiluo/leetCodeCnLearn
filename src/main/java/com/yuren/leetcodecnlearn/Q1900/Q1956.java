package com.yuren.leetcodecnlearn.Q1900;

import java.util.*;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-09-27 06:06
 */
public class Q1956 {

    public int minDayskVariants(int[][] points, int k) {
        int n = points.length;
        int[][] cp = new int[n][2];
        Set<Long> pointHash = new HashSet<>();
        long multer = 2000000001;
        for (int i = 0; i < n; i++) {
            cp[i][0] = (points[i][0] + points[i][1]);
            cp[i][1] = points[i][0] - points[i][1];
            pointHash.add(cp[i][0] * multer + cp[i][1]);
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (cp[i][0] > cp[j][0]) {
                    int t = cp[i][0];
                    cp[i][0] = cp[j][0];
                    cp[j][0] = t;
                    t = cp[i][1];
                    cp[i][1] = cp[j][1];
                    cp[j][1] = t;
                }
            }
        }

        int minDis = 1000000000;
        for (int i = 0; i <= n - k; i++) {

            for (int j = k; j <= n - i; j++) {
                int xDis = cp[i + j - 1][0] - cp[i][0];
                if (xDis < minDis) {
                    List<Integer> yAxis = new ArrayList<>();
                    for (int t = 0; t < j; t++) {
                        yAxis.add(cp[i + t][1]);
                    }
                    Collections.sort(yAxis);
                    for (int t = 0; t <= j - k; t++) {
                        int yDis = yAxis.get(t + k - 1) - yAxis.get(t);
                        int yStart = yAxis.get(t);
                        int xStart = cp[i][0];
                        int dis = Math.max(xDis, yDis);

                        if (dis % 2 == 0 && xDis == yDis && (xStart + yStart) % 2 != 0) {
                            dis++;
                        }
                        minDis = Math.min(minDis, dis);
                    }
                }

            }
        }
        return minDis == 0 ? 0 : (minDis - 1) / 2 + 1;

    }
}

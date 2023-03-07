package com.yuren.leetcodecnlearn.Q900;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Function;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-08-27 23:36
 */
public class Q963 {
    public double minAreaFreeRect(int[][] points) {
        if (points.length < 4) {
            return 0;
        }

        Set<String> set = new HashSet<>();
        for (int[] point : points) {
            set.add(format().apply(point));
        }

        double area = 0;
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                int d2ij = distance2(points[i], points[j]);
                for (int k = j + 1; k < points.length; k++) {
                    int d2ik = distance2(points[i], points[k]);
                    int d2jk = distance2(points[j], points[k]);
                    if (d2ij + d2ik != d2jk) {
                        continue;
                    }

                    int x = points[j][0] + points[k][0] - points[i][0];
                    int y = points[j][1] + points[k][1] - points[i][1];
                    int[] pointXY = new int[]{x, y};
                    if (!set.contains(format().apply(pointXY))) {
                        continue;
                    }

                    double tmpArea = Math.sqrt(d2ij) * Math.sqrt(d2ik);
                    if (area == 0 || area > tmpArea) {
                        area = tmpArea;
                    }
                }
            }
        }

        return area;
    }

    private Function<int[], String> format() {
        return point -> String.format("%d_%d", point[0], point[1]);
    }

    private int distance2(int[] a, int[] b) {
        return (b[0] - a[0]) * (b[0] - a[0]) + (b[1] - a[1]) * (b[1] - a[1]);
    }

}

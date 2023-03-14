package com.yuren.leetcodecnlearn.Q1400;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-03-14 23:00
 */
public class Q1453 {
    static final double EPSILON = 1e-6;

    public int numPoints(int[][] darts, int r) {
        int n = darts.length;
        if (n == 1) {
            return 1;
        }
        int maxPoints = 1;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int squaredDistance = (darts[j][0] - darts[i][0]) * (darts[j][0] - darts[i][0]) + (darts[j][1] - darts[i][1]) * (darts[j][1] - darts[i][1]);
                if (squaredDistance > 4 * r * r) {
                    continue;
                }
                int count;
                if (squaredDistance == 4 * r * r) {
                    double[] center = {(darts[i][0] + darts[j][0]) / 2.0, (darts[i][1] + darts[j][1]) / 2.0};
                    count = countDartsInCircle(darts, r, center);
                } else {
                    double distance = Math.sqrt(squaredDistance);
                    double halfDistance = Math.sqrt(squaredDistance) / 2;
                    double remainDistance = Math.sqrt(r * r - halfDistance * halfDistance);
                    double xMid = (darts[i][0] + darts[j][0]) / 2.0, yMid = (darts[i][1] + darts[j][1]) / 2.0;
                    double xDelta = (darts[j][0] - darts[i][0]) / distance, yDelta = (darts[j][1] - darts[i][1]) / distance;
                    double[] center1 = {xMid + remainDistance * yDelta, yMid - remainDistance * xDelta};
                    double[] center2 = {xMid - remainDistance * yDelta, yMid + remainDistance * xDelta};
                    count = Math.max(countDartsInCircle(darts, r, center1), countDartsInCircle(darts, r, center2));
                }
                maxPoints = Math.max(maxPoints, count);
            }
        }
        return maxPoints;
    }

    public int countDartsInCircle(int[][] darts, int r, double[] center) {
        int count = 0;
        for (int[] dart : darts) {
            double squaredDistance = (dart[0] - center[0]) * (dart[0] - center[0]) + (dart[1] - center[1]) * (dart[1] - center[1]);
            if (squaredDistance - r * r <= EPSILON) {
                count++;
            }
        }
        return count;
    }
}

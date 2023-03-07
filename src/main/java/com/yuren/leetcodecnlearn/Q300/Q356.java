package com.yuren.leetcodecnlearn.Q300;

import java.util.HashSet;
import java.util.Set;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2021-12-07 23:37
 */


public class Q356 {
    public boolean isReflected(int[][] points) {
        Set<Point> set = new HashSet<>();
        int minX = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        for (int[] point : points) {
            int x = point[0];
            int y = point[1];
            if (x < minX) {
                minX = x;
            }
            if (x > maxX) {
                maxX = x;
            }
            set.add(new Point(x, y));
        }
        int xSum = minX + maxX;
        for (int[] point : points) {
            if (!set.contains(new Point(xSum - point[0], point[1]))) {
                return false;
            }
        }
        return true;
    }

    private static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + x;
            result = prime * result + y;
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            Point other = (Point) obj;
            if (x != other.x)
                return false;
            return y == other.y;
        }
    }
}

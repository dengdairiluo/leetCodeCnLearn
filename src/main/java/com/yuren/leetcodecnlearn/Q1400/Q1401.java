package com.yuren.leetcodecnlearn.Q1400;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-02-23 01:01
 */
public class Q1401 {
    public boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
        return f(xCenter - radius, yCenter, x1, y1, x2, y2) || f(xCenter + radius, yCenter, x1, y1, x2, y2)
                || f(xCenter, yCenter + radius, x1, y1, x2, y2) || f(xCenter, yCenter - radius, x1, y1, x2, y2)
                || d(radius, xCenter, yCenter, x1, y1) || d(radius, xCenter, yCenter, x2, y2)
                || d(radius, xCenter, yCenter, x1, y2) || d(radius, xCenter, yCenter, x2, y1)
                || d2(radius, xCenter, yCenter, x1, y1, x2, y2);
    }

    private boolean d2(int r, int x, int y, int x1, int y1, int x2, int y2) {
        return (x >= x1 && x <= x2 && (Math.abs(y - y1) <= r && Math.abs(y - y2) <= r))
                || (y >= y1 && y <= y2 && (Math.abs(x - x1) <= r && Math.abs(x - x2) <= r));
    }

    private boolean d(int radius, int xCenter, int yCenter, int x1, int y1) {
        return (x1 - xCenter) * (x1 - xCenter) + (y1 - yCenter) * (y1 - yCenter) <= radius * radius;
    }

    private boolean f(int x, int y, int x1, int y1, int x2, int y2) {
        return x >= x1 && x <= x2 && y >= y1 && y <= y2;
    }

}

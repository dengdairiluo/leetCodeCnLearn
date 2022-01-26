package com.yuren.leetcodecnlearn;

public class Q478 {
    private double x;

    private double y;

    private double radius;

    public Q478(double _radius, double x_center, double y_center) {
        radius = _radius;
        x = x_center;
        y = y_center;
    }

    public double[] randPoint() {
        double dx = (2 * Math.random() - 1) * radius;
        double dy = (2 * Math.random() - 1) * radius;
        while ((dx * dx + dy * dy) > radius * radius) {
            dx = (2 * Math.random() - 1) * radius;
            dy = (2 * Math.random() - 1) * radius;
        }
        return new double[]{x + dx, y + dy};
    }
}

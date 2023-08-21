package com.yuren.leetcodecnlearn.Q1800;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-08-21 23:36
 */
public class Q1870 {
    public int minSpeedOnTime(int[] dist, double hour) {
        int n = dist.length;
        int maxSpeed = 1;
        // 前面n-1个元素，最少要用n-1小时，故取前n-1元素的最大值即可
        for (int i = 0; i < n - 1; i++) {
            maxSpeed = Math.max(maxSpeed, dist[i]);
        }
        // maxSpeed还需与最后一个元素的最大可能速度做比较
        maxSpeed = Math.max(maxSpeed, (int) (dist[n - 1] * 1.0d / (hour - n + 1)) + 1);
        int l = 0, r = maxSpeed + 1;
        while (l + 1 < r) {
            int c = l + (r - l) / 2;
            if (getTime(dist, c) <= hour) {
                r = c;
            } else {
                l = c;
            }
        }
        return r == maxSpeed + 1 ? -1 : r;
    }

    private double getTime(int[] dist, int speed) {
        double time = 0.0;
        int n = dist.length;
        for (int i = 0; i < n - 1; i++) {
            time += (double) (dist[i] - 1) / speed + 1;
        }
        time += dist[n - 1] * 1.0d / speed;
        return time;
    }
}

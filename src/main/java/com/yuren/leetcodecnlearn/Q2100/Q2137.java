package com.yuren.leetcodecnlearn.Q2100;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-12-26 23:18
 */
public class Q2137 {
    public double equalizeWater(int[] buckets, int loss) {
        double l = 0, r = 100000;
        while (r - l > 1e-5) {
            double mid = (l + r) / 2;
            if (check(buckets, loss, mid)) {
                l = mid;
            } else {
                r = mid;
            }
        }
        return l;
    }

    public boolean check(int[] buckets, int loss, double avg) {
        int n = buckets.length;
        double less = 0, more = 0;
        for (double x : buckets) {
            if (x > avg) {
                more += x - avg;
            } else {
                less += avg - x;
            }
        }
        return more * ((100 - loss) / 100.0) - less >= 0;
    }
}

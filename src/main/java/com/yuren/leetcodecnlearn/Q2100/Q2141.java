package com.yuren.leetcodecnlearn.Q2100;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-12-28 22:56
 */
public class Q2141 {
    public long maxRunTime(int n, int[] batteries) {
        long sum = 0;
        int min = 1000000000;
        int max = 0;
        for (int num : batteries) {
            sum += num;
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        if (n == batteries.length) {
            return min;
        }
        if (sum >= (long) max * n) {
            return sum / n;
        }
        int l = min;
        int r = max;
        int ans = 0;
        while (l <= r) {
            int m = (l + r) / 2;
            if (check(m, batteries, n)) {
                ans = m;
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return ans;
    }

    boolean check(int time, int b[], int n) {
        long sum = 0;
        for (int num : b) {
            if (num > time) {
                n--;
            } else {
                sum += num;
            }
            if (sum >= 1L * time * n) {
                return true;
            }
        }
        return false;
    }
}

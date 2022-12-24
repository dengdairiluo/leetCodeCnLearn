package com.yuren.leetcodecnlearn.Q1200;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-10-27 23:31
 */
public class Q1109 {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] counters = new int[n];
        for (int[] booking : bookings) {
            counters[booking[0] - 1] += booking[2];
            if (booking[1] < n) {
                counters[booking[1]] -= booking[2];
            }
        }
        for (int i = 1; i < n; ++i) {
            counters[i] += counters[i - 1];
        }
        return counters;
    }

}

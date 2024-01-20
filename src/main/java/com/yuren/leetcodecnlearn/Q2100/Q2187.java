package com.yuren.leetcodecnlearn.Q2100;

import java.util.Arrays;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-01-20 23:18
 */
public class Q2187 {
    public long minimumTime(int[] time, int totalTrips) {
        if (time.length == 1) {
            return time[0] * (long) totalTrips;
        }

        long minTime = 1;
        long maxTime = Arrays.stream(time).max().getAsInt() * (long) totalTrips;
        while (minTime < maxTime) {
            long mid = minTime + (maxTime - minTime) / 2;
            if (isTimeEnough(time, totalTrips, mid)) {
                maxTime = mid;
            } else {
                minTime = mid + 1;
            }
        }
        return minTime;
    }

    private boolean isTimeEnough(int[] time, int totalTrips, long timeTaken) {
        long finishedTrips = 0;
        for (int t : time) {
            finishedTrips += timeTaken / t;
            if (finishedTrips >= totalTrips) {
                return true;
            }
        }
        return false;
    }

}

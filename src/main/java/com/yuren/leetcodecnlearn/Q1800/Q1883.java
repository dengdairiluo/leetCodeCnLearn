package com.yuren.leetcodecnlearn.Q1800;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-08-26 21:12
 */
public class Q1883 {
    public int minSkips(int[] dists, int speed, int hoursBefore) {

        int n = dists.length;

        long limit = (long) speed * hoursBefore;

        long sumDist = 0;
        for (int dist : dists) {
            sumDist += dist;
        }

        if (sumDist > limit) {
            return -1;
        }

        long[] minSums = new long[n];

        int useHours = 0;
        for (int i = 0; i < n; i++) {
            minSums[i] = dists[i] + (long) useHours * speed;
            useHours += (dists[i] - 1) / speed + 1;
        }
        if (minSums[n - 1] <= limit) {
            return 0;
        }
        for (int i = 1; i < n; i++) {
            long prevMinSum = minSums[i - 1];
            for (int j = i; j < n; j++) {
                long minSum = Math.min(prevMinSum, ((minSums[j - 1] - 1) / speed + 1) * speed) + dists[j];
                prevMinSum = minSums[j];
                minSums[j] = minSum;
            }
            if (minSums[n - 1] <= limit) {
                return i;
            }
        }
        throw new IllegalStateException();
    }
}

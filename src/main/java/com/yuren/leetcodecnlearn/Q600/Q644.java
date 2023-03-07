package com.yuren.leetcodecnlearn.Q600;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-04-11 23:13
 */
public class Q644 {
    public boolean check(int[] preSums, int k, double avg) {
        double min = 0;
        for (int i = k; i < preSums.length; i++) {
            double now = preSums[i];
            now -= i * avg;
            if (now - min >= 0) {
                return true;
            }
            double ne = preSums[i - k + 1] - (i - k + 1) * avg;
            if (ne < min) {
                min = ne;
            }
        }
        return false;
    }

    public double findMaxAverage(int[] nums, int k) {
        int n = nums.length;
        int[] prefixSum = new int[n + 1];
        prefixSum[0] = 0;
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }
        double dL = -100000000;
        double tL = 100000000;
        while ((tL - dL) > 0.00001) {
            double mid = (dL + tL) / 2;
            if (check(prefixSum, k, mid)) {
                dL = mid;
            } else {
                tL = mid;
            }
        }
        return dL;
    }
}

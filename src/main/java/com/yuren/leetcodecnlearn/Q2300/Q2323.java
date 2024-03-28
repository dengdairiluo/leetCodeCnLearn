package com.yuren.leetcodecnlearn.Q2300;

import java.util.Arrays;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-03-28 23:58
 */
public class Q2323 {
    public int minimumTime(int[] jobs, int[] workers) {
        int minTime = 0;
        Arrays.sort(jobs);
        Arrays.sort(workers);
        int n = jobs.length;
        for (int i = 0; i < n; i++) {
            int currTime = (jobs[i] - 1) / workers[i] + 1;
            minTime = Math.max(minTime, currTime);
        }
        return minTime;
    }
}

package com.yuren.leetcodecnlearn.Q1700;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-06-18 23:06
 */
public class Q1701 {
    public double averageWaitingTime(int[][] customers) {
        int n = customers.length;
        int curr = customers[0][0];
        long tot = 0;
        for (int i = 0; i < n; i++) {
            int[] ci = customers[i];
            int arr = ci[0], tt = ci[1];
            if (curr <= arr) {
                curr = arr + tt;
                tot += tt;
            } else {
                curr += tt;
                tot += curr - arr;
            }
        }
        return ((double) tot / n);
    }
}

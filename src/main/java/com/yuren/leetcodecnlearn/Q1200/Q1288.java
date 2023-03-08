package com.yuren.leetcodecnlearn.Q1200;

import java.util.Arrays;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-01-15 22:58
 */
public class Q1288 {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        int ans = 0, range = 0;
        for (int[] ints : intervals) {
            int b = ints[1];
            if (b > range) {
                ans += 1;
                range = b;
            }
        }
        return ans;
    }
}

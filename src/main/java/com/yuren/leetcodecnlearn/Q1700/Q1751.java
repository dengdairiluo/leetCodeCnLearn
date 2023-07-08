package com.yuren.leetcodecnlearn.Q1700;

import java.util.Arrays;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-07-08 22:44
 */
public class Q1751 {

    public int maxValue(int[][] events, int k) {

        if (k == 1) {
            int max = 0;
            for (int[] event : events) {
                if (max < event[2]) max = event[2];
            }
            return max;
        }

        Arrays.sort(events, (a, b) -> (a[0] - b[0]));
        int n = events.length;
        int[][] memo = new int[n][k + 1];
        int result = dfs(events, 0, k, memo);

        return result;
    }

    private int dfs(int[][] events, int curr, int k, int[][] memo) {

        if (curr >= events.length || k == 0) {
            return 0;
        }

        if (memo[curr][k] > 0) {
            return memo[curr][k];
        }

        int next = binarySearch(events, events[curr][1] + 1, curr + 1);

        int result = events[curr][2] + dfs(events, next, k - 1, memo);

        result = Math.max(result, dfs(events, curr + 1, k, memo));

        return memo[curr][k] = result;
    }

    private int binarySearch(int[][] events, int target, int start) {

        int n = events.length, end = n;

        while (start < end) {
            int mid = start + ((end - start) >> 1);
            if (events[mid][0] < target) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start;
    }
}

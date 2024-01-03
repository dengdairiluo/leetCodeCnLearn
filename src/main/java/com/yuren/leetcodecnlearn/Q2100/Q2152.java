package com.yuren.leetcodecnlearn.Q2100;

import java.util.Arrays;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-01-03 23:30
 */
public class Q2152 {
    public int minimumLines(int[][] points) {
        int n = points.length;
        boolean[] sameLine = new boolean[1 << n];
        for (int i = 0; i < 1 << n; i++) {
            if (Integer.bitCount(i) <= 2) {
                sameLine[i] = true;
                continue;
            }

            if (!sameLine[i - ((i & (-i)))]) {
                sameLine[i] = false;
                continue;
            }

            int[] items = new int[3];
            int last = i;
            for (int j = 0; j < 3; j++) {
                int lastPos = Integer.bitCount((last & (-last)) - 1);
                last = last & (last - 1);
                items[j] = lastPos;

            }
            sameLine[i] = sameLine(points[items[0]], points[items[1]], points[items[2]]);
        }
        int[] dp = new int[1 << n];
        Arrays.fill(dp, n);
        dp[0] = 0;
        for (int i = 1; i < 1 << n; i++) {
            for (int j = i; j > 0; j = ((j - 1) & i)) {
                if (sameLine[j]) {
                    dp[i] = Math.min(dp[i], dp[i ^ j] + 1);
                }
            }
        }
        return dp[(1 << n) - 1];
    }

    private boolean sameLine(int[] a, int[] b, int[] c) {
        return (a[1] - b[1]) * (a[0] - c[0]) == (a[0] - b[0]) * (a[1] - c[1]);
    }
}

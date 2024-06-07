package com.yuren.leetcodecnlearn.Q2400;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-06-07 下午11:47
 */
public class Q2464 {
    int dp[];

    public int validSubarraySplit(int[] a) {
        int n = a.length;
        dp = new int[n];
        return help(a, 0);
    }

    public int help(int a[], int idx) {
        int n = a.length;
        if (idx == n - 1) {
            return a[idx] == 1 ? -1 : 1;
        }
        if (idx >= n) {
            return 0;
        }

        if (dp[idx] != 0) {
            return dp[idx];
        }

        int res = Integer.MAX_VALUE;
        for (int i = idx; i < n; i++) {
            if (gcd(a[idx], a[i]) == 1) {
                continue;
            }
            int r = help(a, i + 1);
            if (r >= 0) {
                res = Math.min(res, 1 + r);
            }
        }

        dp[idx] = res == Integer.MAX_VALUE ? -1 : res;
        return dp[idx];
    }

    public int gcd(int a, int b) {
        int x = Math.min(a, b);
        int y = Math.max(a, b);

        while (y % x != 0) {
            int t = y % x;
            y = x;
            x = t;

        }

        return x;
    }
}

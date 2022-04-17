package com.yuren.leetcodecnlearn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-04-17 23:24
 */
public class Q656 {
    public List<Integer> cheapestJump(int[] a, int b) {
        int[] next = new int[a.length];
        long[] dp = new long[a.length];
        Arrays.fill(next, -1);
        List<Integer> res = new ArrayList<>();
        for (int i = a.length - 2; i >= 0; i--) {
            long minCost = Integer.MAX_VALUE;
            for (int j = i + 1; j <= i + b && j < a.length; j++) {
                if (a[j] >= 0) {
                    long cost = a[i] + dp[j];
                    if (cost < minCost) {
                        minCost = cost;
                        next[i] = j;
                    }
                }
            }
            dp[i] = minCost;
        }
        int i;
        for (i = 0; i < a.length && next[i] > 0; i = next[i]) {
            res.add(i + 1);
        }
        if (i == a.length - 1 && a[i] >= 0) {
            res.add(a.length);
        } else {
            return new ArrayList<>();
        }
        return res;
    }
}

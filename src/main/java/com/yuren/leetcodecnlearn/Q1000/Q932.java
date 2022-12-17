package com.yuren.leetcodecnlearn.Q1000;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-08-15 00:07
 */
public class Q932 {
    Map<Integer, int[]> memo;

    public int[] beautifulArray(int n) {
        memo = new HashMap<>();
        return f(n);
    }

    public int[] f(int n) {
        if (memo.containsKey(n)) {
            return memo.get(n);
        }

        int[] ans = new int[n];
        if (n == 1) {
            ans[0] = 1;
        } else {
            int t = 0;
            // odds
            for (int x : f((n + 1) / 2)) {
                ans[t++] = 2 * x - 1;
            }
            // evens
            for (int x : f(n / 2)) {
                ans[t++] = 2 * x;
            }
        }
        memo.put(n, ans);
        return ans;
    }
}

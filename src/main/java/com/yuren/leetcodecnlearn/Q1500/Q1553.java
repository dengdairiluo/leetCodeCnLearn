package com.yuren.leetcodecnlearn.Q1500;

import java.util.HashMap;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-04-24 23:54
 */
public class Q1553 {
    public static HashMap<Integer, Integer> dp = new HashMap<>();

    public int minDays(int n) {
        if (n <= 1) {
            return n;
        }
        if (dp.containsKey(n)) {
            return dp.get(n);
        }
        int ans = Math.min(n % 2 + 1 + minDays(n / 2), n % 3 + 1 + minDays(n / 3));
        dp.put(n, ans);
        return ans;
    }
}

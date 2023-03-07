package com.yuren.leetcodecnlearn.Q900;

import java.util.Arrays;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-08-24 23:39
 */
public class Q956 {
    public int tallestBillboard(int[] rods) {
        int s = 0;
        for (int rod : rods) {
            s += rod;
        }

        int[] dp = new int[s + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for (int h : rods) {
            int[] current = dp.clone();
            for (int i = 0; i <= s - h; i++) {
                if (current[i] < 0) continue;
                dp[i + h] = Math.max(dp[i + h], current[i]);
                dp[Math.abs(i - h)] = Math.max(dp[Math.abs(i - h)], current[i] + Math.min(h, i));
            }
        }

        return dp[0];
    }
}

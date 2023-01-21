package com.yuren.leetcodecnlearn.Q1400;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-01-21 23:51
 */
public class Q1312 {
    public int minInsertions(String s) {
        if (s == null || s.length() < 2) {
            return 0;
        }
        int n = s.length();
        char[] chars = s.toCharArray();
        int[] dp = new int[n];
        for (int i = n - 2; i >= 0; i--) {
            int pre = 0;
            for (int j = i + 1; j < n; j++) {
                int temp = dp[j];
                dp[j] = chars[i] == chars[j] ? pre : Math.min(dp[j], dp[j - 1]) + 1;
                pre = temp;
            }
        }
        return dp[n - 1];
    }
}

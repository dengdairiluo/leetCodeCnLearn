package com.yuren.leetcodecnlearn.Q1500;

import java.util.Arrays;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-04-15 23:25
 */
public class Q1531 {
    private int[][] dp;
    private char[] chars;
    private int n;

    public int getLengthOfOptimalCompression(String s, int k) {
        this.chars = s.toCharArray();
        this.n = s.length();
        this.dp = new int[n][k + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return dp(0, k);
    }

    private int dp(int i, int k) {
        if (k < 0) return n;
        if (i + k >= n) {
            return 0;
        }

        if (dp[i][k] != -1) {
            return dp[i][k];
        }
        int ans = dp(i + 1, k - 1);
        int diff = 0;
        int count = 0;
        int length = 0;
        for (int j = i; j < n && diff <= k; ++j) {
            if (chars[j] == chars[i]) {
                count++;
                if (count <= 2 || count == 10 || count == 100) {
                    length++;
                }
            } else {
                diff++;
            }
            ans = Math.min(ans, length + dp(j + 1, k - diff));
        }

        dp[i][k] = ans;
        return ans;
    }
}

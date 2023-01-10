package com.yuren.leetcodecnlearn.Q1300;

import java.util.Arrays;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-01-10 23:58
 */
public class Q1278 {
    private static final int INF = 0x3f3f3f3f;

    public int palindromePartition(String str, int K) {
        // cost[i][j] means for str[i~j],
        // the minimal number of characters that you need to change,
        // to make it palindrome.
        char[] s = str.toCharArray();
        int n = s.length;
        int[][] cost = new int[n][n];
        for (int i = n - 2; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                if (s[i] == s[j]) {
                    cost[i][j] = cost[i + 1][j - 1];
                } else {
                    cost[i][j] = 1 + cost[i + 1][j - 1];
                }
            }
        }
        //dp[i][j] means for str[0:i-1],
        //the minimal number of characters that you need to change,
        //to divide the string into j palindriomes.
        int[][] dp = new int[n + 1][K + 1];
        for (int[] row : dp) {
            Arrays.fill(row, INF);
        }
        dp[0][0] = 0;
        for (int right = 1; right <= n; right++) {
            for (int group = 1; group <= K; group++) {
                update(dp, right, group, cost);
            }
        }
        return dp[n][K];
    }

    private void update(int[][] dp, int right, int group, int[][] cost) {
        for (int left = group - 1; left <= right - 1; left++) {
            dp[right][group] = Math.min(dp[right][group], dp[left][group - 1] + cost[left][right - 1]);
        }
    }
}

package com.yuren.leetcodecnlearn.Q1600;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-05-27 23:47
 */
public class Q1639 {
    private static int MOD = (int) 1e9 + 7;

    public int numWays(String[] words, String target) {
        int l1 = words[0].length();
        int l2 = target.length();
        int[][] dics = new int[l1 + 1][26];
        for (String str : words) {
            for (int j = 1; j <= l1; j++) {
                dics[j][str.charAt(j - 1) - 'a']++;
            }
        }
        long[][] dp = new long[l2 + 1][l1 + 1];
        for (int i = 0; i <= l1; i++) {
            dp[0][i] = 1;
        }
        // target中第i个字符
        for (int i = 1; i <= l2; i++) {
            int to = l1 - l2 + i;
            int c = target.charAt(i - 1) - 'a';
            // 来自words中第j位置，方法数
            for (int j = i; j <= to; j++) {
                long cur = dics[j][c] * dp[i - 1][j - 1] + dp[i][j - 1];
                dp[i][j] = (cur + MOD) % MOD;
            }
        }
        return (int) dp[l2][l1];
    }
}

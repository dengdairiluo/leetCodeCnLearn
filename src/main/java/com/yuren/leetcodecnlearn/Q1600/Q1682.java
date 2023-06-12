package com.yuren.leetcodecnlearn.Q1600;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-06-12 23:35
 */
public class Q1682 {
    public int longestPalindromeSubseq(String s) {

        int n = s.length();
        char[] a = s.toCharArray();
        int[][] dp1 = new int[n][n];
        char[][] dp2 = new char[n][n];

        for (int len = 1; len < n; len++) {
            for (int i = 0; i + len < n; i++) {
                int j = i + len;

                if (a[i] == a[j] && (dp1[i + 1][j - 1] == 0 || dp2[i + 1][j - 1] != a[i])) {

                    dp1[i][j] = dp1[i + 1][j - 1] + 2;
                    dp2[i][j] = a[i];
                } else {

                    if (dp1[i + 1][j] > dp1[i][j - 1]) {
                        dp1[i][j] = dp1[i + 1][j];
                        dp2[i][j] = dp2[i + 1][j];

                    } else {
                        dp1[i][j] = dp1[i][j - 1];
                        dp2[i][j] = dp2[i][j - 1];
                    }
                }

            }
        }
        return dp1[0][n - 1];
    }
}

package com.yuren.leetcodecnlearn.Q1000;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-10-20 23:54
 */
public class Q1092 {
    public String shortestCommonSupersequence(String str1, String str2) {
        int n = str1.length(), m = str2.length();
        str1 = " " + str1;
        str2 = " " + str2;
        char[] s1 = str1.toCharArray(), s2 = str2.toCharArray();
        int[][] f = new int[n + 10][m + 10];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1[i] == s2[j]) f[i][j] = f[i - 1][j - 1] + 1;
                else f[i][j] = Math.max(f[i - 1][j], f[i][j - 1]);
            }
        }
        StringBuilder sb = new StringBuilder();
        int i = n, j = m;
        while (i > 0 || j > 0) {
            if (i == 0) sb.append(s2[j--]);
            else if (j == 0) sb.append(s1[i--]);
            else {
                if (s1[i] == s2[j]) {
                    sb.append(s1[i]);
                    i--;
                    j--;
                } else if (f[i][j] == f[i - 1][j]) {
                    sb.append(s1[i--]);
                } else {
                    sb.append(s2[j--]);
                }
            }
        }
        return sb.reverse().toString();
    }
}

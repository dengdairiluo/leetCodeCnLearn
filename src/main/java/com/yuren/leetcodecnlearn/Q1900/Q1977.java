package com.yuren.leetcodecnlearn.Q1900;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-10-09 23:46
 */
public class Q1977 {
    int[][] lcp;
    char[] a;
    int mod = (int) 1e9 + 7;

    public int numberOfCombinations(String num) {
        a = num.toCharArray();
        if (a[0] == '0') return 0;
        int n = a.length;
        lcp = new int[n + 1][n + 1];
        for (int i = n - 1; i >= 0; i--)
            for (int j = n - 1; j >= 0; j--) {
                if (a[i] == a[j]) lcp[i][j] = lcp[i + 1][j + 1] + 1;
            }
        int[][] f = new int[n][n];
        for (int i = 0; i < n; i++) f[0][i] = 1;
        for (int i = 1; i < n; i++) {
            int sum = 0;
            if (a[i] == '0') continue;
            for (int j = i, k = i - 1; j < n; k--, j++) {
                f[i][j] = sum;
                if (k < 0) continue;
                if (a[k] != '0' && eq(k, i, j + 1)) {
                    f[i][j] = (f[i][j] + f[k][i - 1]) % mod;
                }
                sum = (sum + f[k][i - 1]) % mod;
            }
        }
        int as = 0;
        for (int i = 0; i < n; i++) as = (as + f[i][n - 1]) % mod;
        return as;
    }

    private boolean eq(int l1, int l2, int r2) {
        int l = lcp[l1][l2];
        return l >= r2 - l2 || a[l + l1] < a[l + l2];
    }
}

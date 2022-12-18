package com.yuren.leetcodecnlearn.Q1100;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-10-01 23:39
 */
public class Q1044 {
    private static final int N = 30010;
    int[] x = new int[N], y = new int[N], c = new int[N];
    int[] sa = new int[N], rk = new int[N], height = new int[N];

    void swap(int[] a, int[] b) {
        int n = a.length;
        int[] c = a.clone();
        for (int i = 0; i < n; i++) {
            a[i] = b[i];
        }
        for (int i = 0; i < n; i++) {
            b[i] = c[i];
        }
    }

    public String longestDupSubstring(String s) {
        int n = s.length(), m = 128;
        s = " " + s;
        char[] cs = s.toCharArray();
        // sa：两遍基数排序，板子背不下来也可以直接使用 sort，复杂度退化到 n \log^2 n
        for (int i = 1; i <= n; i++) {
            x[i] = cs[i];
            c[x[i]]++;
        }
        for (int i = 2; i <= m; i++) {
            c[i] += c[i - 1];
        }
        for (int i = n; i > 0; i--) {
            sa[c[x[i]]--] = i;
        }
        for (int k = 1; k <= n; k <<= 1) {
            int cur = 0;
            for (int i = n - k + 1; i <= n; i++) {
                y[++cur] = i;
            }
            for (int i = 1; i <= n; i++) {
                if (sa[i] > k) {
                    y[++cur] = sa[i] - k;
                }
            }
            for (int i = 1; i <= m; i++) {
                c[i] = 0;
            }
            for (int i = 1; i <= n; i++) {
                c[x[i]]++;
            }
            for (int i = 2; i <= m; i++) {
                c[i] += c[i - 1];
            }
            for (int i = n; i > 0; i--) {
                sa[c[x[y[i]]]--] = y[i];
                y[i] = 0;
            }
            swap(x, y);
            x[sa[1]] = cur = 1;
            for (int i = 2; i <= n; i++) {
                if (y[sa[i]] == y[sa[i - 1]] && y[sa[i] + k] == y[sa[i - 1] + k]) {
                    x[sa[i]] = cur;
                } else {
                    x[sa[i]] = ++cur;
                }
            }
            if (cur == n) {
                break;
            }
            m = cur;
        }
        // height
        int k = 0;
        for (int i = 1; i <= n; i++) {
            rk[sa[i]] = i;
        }
        for (int i = 1; i <= n; i++) {
            if (rk[i] == 1) {
                continue;
            }
            int j = sa[rk[i] - 1];
            k = k > 0 ? k - 1 : k;
            while (i + k <= n && j + k <= n && cs[i + k] == cs[j + k]) {
                k++;
            }
            height[rk[i]] = k;
        }
        int idx = -1, max = 0;
        for (int i = 1; i <= n; i++) {
            if (height[i] > max) {
                max = height[i];
                idx = sa[i];
            }
        }
        return max == 0 ? "" : s.substring(idx, idx + max);
    }
}

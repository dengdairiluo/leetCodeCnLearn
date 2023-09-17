package com.yuren.leetcodecnlearn.Q1900;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-09-17 20:13
 */
public class Q1927 {
    public boolean sumGame(String num) {
        char[] a = num.toCharArray();
        int nn = a.length;
        int x = 0, y = 0, m = 0, n = 0;
        for (int i = 0; i < nn / 2; i++) {
            if (a[i] == '?') {
                m++;
            } else {
                x += (int) (a[i] - '0');
            }
        }
        for (int i = nn / 2; i < nn; i++) {
            if (a[i] == '?') {
                n++;
            } else {
                y += (int) (a[i] - '0');
            }
        }
        if (x < y) {
            int t1 = y, t2 = n;
            y = x;
            x = t1;
            n = m;
            m = t2;
        }

        if (x == y && m == n) return false;
        if (m >= n) return true;
        if ((n - m) / 2 * 9 < x - y) return true;
        if ((n - m + 1) / 2 * 9 > x - y) return true;
        return false;
    }
}

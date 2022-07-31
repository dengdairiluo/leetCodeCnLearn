package com.yuren.leetcodecnlearn;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-07-31 22:10
 */
public class Q900 {
    private final int[] a;
    private int i, q;

    public Q900(int[] a) {
        this.a = a;
        i = q = 0;
    }

    public int next(int n) {
        while (i < a.length) {
            if (q + n > a[i]) {
                n -= a[i] - q;
                q = 0;
                i += 2;
            } else {
                q += n;
                return a[i + 1];
            }
        }

        return -1;
    }
}

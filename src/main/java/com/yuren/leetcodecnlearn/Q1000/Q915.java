package com.yuren.leetcodecnlearn.Q1000;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-08-08 23:49
 */
public class Q915 {
    public int partitionDisjoint(int[] a) {
        int n = a.length;
        int[] maxLeft = new int[n];
        int[] maxRight = new int[n];

        int m = a[0];
        for (int i = 0; i < n; ++i) {
            m = Math.max(m, a[i]);
            maxLeft[i] = m;
        }

        m = a[n - 1];
        for (int i = n - 1; i >= 0; --i) {
            m = Math.min(m, a[i]);
            maxRight[i] = m;
        }

        for (int i = 1; i < n; ++i) {
            if (maxLeft[i - 1] <= maxRight[i]) {
                return i;
            }
        }

        throw null;
    }
}

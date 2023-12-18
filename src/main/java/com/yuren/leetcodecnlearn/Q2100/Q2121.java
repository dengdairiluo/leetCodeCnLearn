package com.yuren.leetcodecnlearn.Q2100;

import java.util.Arrays;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-12-18 23:40
 */
public class Q2121 {
    public long[] getDistances(int[] a) {
        int max = 0;
        for (int i : a) {
            max = Math.max(max, i);
        }

        int[] b = new int[max + 1];//个数
        int[] c = new int[max + 1];//位置
        Arrays.fill(c, -1);
        long[] d = new long[a.length];//累加和
        for (int i = 0; i < a.length; i++) {
            if (c[a[i]] > -1) {
                d[i] = d[c[a[i]]] + (long) b[a[i]] * (i - c[a[i]]);
            }
            b[a[i]]++;

            c[a[i]] = i;


        }
        b = new int[max + 1];
        c = new int[max + 1];
        Arrays.fill(c, a.length);
        long[] e = new long[a.length];
        for (int i = a.length - 1; i >= 0; i--) {
            if (c[a[i]] < a.length) {
                e[i] = e[c[a[i]]] + (long) b[a[i]] * (c[a[i]] - i);
            }
            d[i] += e[i];
            b[a[i]]++;

            c[a[i]] = i;

        }
        return d;
    }
}

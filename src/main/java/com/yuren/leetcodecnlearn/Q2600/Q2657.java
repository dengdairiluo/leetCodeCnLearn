package com.yuren.leetcodecnlearn.Q2600;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author 10204
 * @date 2024-09-12 23:50
 */
public class Q2657 {
    public int[] findThePrefixCommonArray(int[] a, int[] b) {
        int n = a.length;
        int[] ans = new int[n];
        long p = 0, q = 0;
        for (int i = 0; i < n; ++i) {
            p |= 1L << a[i];
            q |= 1L << b[i];
            ans[i] = Long.bitCount(p & q);
        }
        return ans;
    }
}

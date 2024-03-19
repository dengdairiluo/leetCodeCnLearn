package com.yuren.leetcodecnlearn.Q2300;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-03-19 23:56
 */
public class Q2305 {
    public int distributeCookies(int[] cookies, int k) {
        int n = cookies.length;
        int[] sum = new int[1 << n];
        for (int i = 0; i < n; i++)
            for (int j = 0, bit = 1 << i; j < bit; j++)
                sum[bit | j] = sum[j] + cookies[i];

        int[] f = sum.clone();
        for (int i = 1; i < k; i++) {
            for (int j = (1 << n) - 1; j > 0; j--) {
                for (int s = j; s > 0; s = (s - 1) & j) {
                    f[j] = Math.min(f[j], Math.max(f[j ^ s], sum[s]));
                }
            }
        }
        return f[(1 << n) - 1];
    }
}

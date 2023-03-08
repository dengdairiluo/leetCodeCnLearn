package com.yuren.leetcodecnlearn.Q1300;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-02-21 23:43
 */
public class Q1399 {
    public int countLargestGroup(int n) {
        int[] f = new int[n + 1];
        int[] m = new int[37];
        for (int i = 1; i <= n; i++) {
            f[i] = f[i / 10] + i % 10;
        }
        for (int i = 1; i <= n; i++) {
            m[f[i]]++;
        }
        int max = 0;
        int ans = 0;
        for (int i : m) {
            if (i > max) {
                max = i;
                ans = 1;
            } else if (i == max) {
                ans++;
            }
        }
        return ans;
    }
}

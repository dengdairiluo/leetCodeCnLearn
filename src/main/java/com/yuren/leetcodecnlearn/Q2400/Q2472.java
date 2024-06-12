package com.yuren.leetcodecnlearn.Q2400;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-06-12 下午11:19
 */
public class Q2472 {
    public int maxPalindromes(String S, int k) {
        char[] s = S.toCharArray();
        int n = s.length;
        int[] f = new int[n + 1];
        for (int i = 0; i < 2 * n - 1; ++i) {
            int l = i / 2, r = l + i % 2; // 中心扩展法
            f[l + 1] = Math.max(f[l + 1], f[l]);
            for (; l >= 0 && r < n && s[l] == s[r]; --l, ++r)
                if (r - l + 1 >= k) {
                    f[r + 1] = Math.max(f[r + 1], f[l] + 1);
                    break;
                }
        }
        return f[n];
    }
}

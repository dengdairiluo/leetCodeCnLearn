package com.yuren.leetcodecnlearn.Q1600;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-05-27 23:45
 */
public class Q1638 {
    public int countSubstrings(String S, String T) {
        char[] s = S.toCharArray(), t = T.toCharArray();
        int ans = 0, n = s.length, m = t.length;
        // d=i-j, j=i-d
        for (int d = 1 - m; d < n; ++d) {
            int i = Math.max(d, 0);
            for (int k0 = i - 1, k1 = k0; i < n && i - d < m; ++i) {
                if (s[i] != t[i - d]) {
                    // 上上一个不同
                    k0 = k1;
                    // 上一个不同
                    k1 = i;
                }
                ans += k1 - k0;
            }
        }
        return ans;
    }
}

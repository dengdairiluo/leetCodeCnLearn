package com.yuren.leetcodecnlearn.Q2500;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-08-02 上午12:04
 */
public class Q2573 {
    public String findTheString(int[][] lcp) {
        int i = 0, n = lcp.length;
        char[] s = new char[n];
        for (char c = 'a'; c <= 'z'; ++c) {
            while (i < n && s[i] > 0) ++i;
            if (i == n) break; // 构造完毕
            for (int j = i; j < n; ++j)
                if (lcp[i][j] > 0) s[j] = c;
        }
        while (i < n) if (s[i++] == 0) return ""; // 没有构造完

        // 直接在原数组上验证
        for (i = n - 1; i >= 0; --i)
            for (int j = n - 1; j >= 0; --j) {
                int actualLCP = s[i] != s[j] ? 0 : i == n - 1 || j == n - 1 ? 1 : lcp[i + 1][j + 1] + 1;
                if (lcp[i][j] != actualLCP) return "";
            }
        return new String(s);
    }
}

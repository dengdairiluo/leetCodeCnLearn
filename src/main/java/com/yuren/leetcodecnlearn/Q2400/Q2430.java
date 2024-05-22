package com.yuren.leetcodecnlearn.Q2400;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-05-22 下午11:50
 */
public class Q2430 {
    public int deleteString(String S) {
        char[] s = S.toCharArray();
        int n = s.length;
        // 特判全部相同的情况
        if (allEqual(s)) return n;
        int[][] lcp = new int[n + 1][n + 1]; // lcp[i][j] 表示 s[i:] 和 s[j:] 的最长公共前缀
        for (int i = n - 1; i >= 0; --i)
            for (int j = n - 1; j > i; --j)
                if (s[i] == s[j])
                    lcp[i][j] = lcp[i + 1][j + 1] + 1;
        int[] f = new int[n];
        for (int i = n - 1; i >= 0; --i) {
            for (int j = 1; i + j * 2 <= n; ++j)
                if (lcp[i][i + j] >= j) // 说明 s[i:i+j] == s[i+j:i+j*2]
                    f[i] = Math.max(f[i], f[i + j]);
            ++f[i];
        }
        return f[0];
    }

    private boolean allEqual(char[] s) {
        for (int i = 1; i < s.length; i++)
            if (s[i] != s[0])
                return false;
        return true;
    }
}

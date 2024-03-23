package com.yuren.leetcodecnlearn.Q2300;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-03-24 01:49
 */
public class Q2311 {
    public int longestSubsequence(String s, int k) {
        char[] t = Integer.toString(k, 2).toCharArray();
        char[] sc = s.toCharArray();
        int m = sc.length, n = t.length;
        if (n > m) return m;
        int i = m - n, j = 0;
        while (j < n && sc[i + j] == t[j]) j++;
        int res = j == n || sc[i + j] < t[j] ? n : n - 1;
        for (j = 0; j < i; j++) {
            if (sc[j] == '0') res++;
        }

        return res;
    }
}

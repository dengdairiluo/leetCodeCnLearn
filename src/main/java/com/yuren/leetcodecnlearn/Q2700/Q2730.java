package com.yuren.leetcodecnlearn.Q2700;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author 10204
 * @date 2024-10-19 20:08
 */
public class Q2730 {
    public int longestSemiRepetitiveSubstring(String S) {
        char[] s = S.toCharArray();
        int ans = 1, left = 0, same = 0, n = s.length;
        for (int right = 1; right < n; right++) {
            if (s[right] == s[right - 1] && ++same > 1) {
                for (left++; s[left] != s[left - 1]; left++);
                same = 1;
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }
}

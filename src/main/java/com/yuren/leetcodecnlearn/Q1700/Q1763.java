package com.yuren.leetcodecnlearn.Q1700;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-07-12 23:57
 */
public class Q1763 {
    public String longestNiceSubstring(String s) {
        int n = s.length();
        int maxPos = 0;
        int maxLen = 0;
        for (int i = 0; i < n; ++i) {
            int lower = 0;
            int upper = 0;
            for (int j = i; j < n; ++j) {
                if (Character.isLowerCase(s.charAt(j))) {
                    lower |= 1 << (s.charAt(j) - 'a');
                } else {
                    upper |= 1 << (s.charAt(j) - 'A');
                }
                if (lower == upper && j - i + 1 > maxLen) {
                    maxPos = i;
                    maxLen = j - i + 1;
                }
            }
        }
        return s.substring(maxPos, maxPos + maxLen);
    }
}

package com.yuren.leetcodecnlearn.Q2600;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author 10204
 * @date 2024-10-02 22:11
 */
public class Q2697 {
    public String makeSmallestPalindrome(String S) {
        char[] s = S.toCharArray();
        for (int i = 0, n = s.length; i < n / 2; i++) {
            char x = s[i], y = s[n - 1 - i];
            if (x > y) s[i] = y;
            else s[n - 1 - i] = x;
        }
        return new String(s);
    }
}

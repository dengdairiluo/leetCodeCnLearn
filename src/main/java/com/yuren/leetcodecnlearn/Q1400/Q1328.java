package com.yuren.leetcodecnlearn.Q1400;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-01-27 23:04
 */
public class Q1328 {
    public String breakPalindrome(String palindrome) {
        int n = palindrome.length();
        if (n == 1) {
            return "";
        }
        char[] cs = palindrome.toCharArray();
        for (int i = 0; i < n / 2; i++) {
            if (cs[i] != 'a') {
                cs[i] = 'a';
                return String.valueOf(cs);
            }
        }
        cs[n - 1] = 'b';
        return String.valueOf(cs);
    }
}

package com.yuren.leetcodecnlearn.Q2300;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-04-01 23:27
 */
public class Q2330 {
    public boolean makePalindrome(String s) {
        int operations = 0;
        for (int left = 0, right = s.length() - 1; left < right && operations <= 2; left++, right--) {
            operations += s.charAt(left) != s.charAt(right) ? 1 : 0;
        }
        return operations <= 2;
    }
}

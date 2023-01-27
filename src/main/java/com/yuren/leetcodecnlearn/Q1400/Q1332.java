package com.yuren.leetcodecnlearn.Q1400;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-01-27 23:11
 */
public class Q1332 {
    public int removePalindromeSub(String s) {
        int n = s.length();
        int i = 0, j = n - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return 2;
            }
            i++;
            j--;
        }
        return 1;
    }
}

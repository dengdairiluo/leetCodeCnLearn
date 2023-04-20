package com.yuren.leetcodecnlearn.Q1500;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-04-20 23:57
 */
public class Q1544 {
    public String makeGood(String s) {
        char[] chars = s.toCharArray();
        int p = 0;
        for (int i = 0; i < chars.length; i++) {
            if (p == 0 || Math.abs(chars[p - 1] - chars[i]) != 32) {
                chars[p++] = chars[i];
            } else {
                p--;
            }
        }
        return String.valueOf(chars, 0, p);
    }
}

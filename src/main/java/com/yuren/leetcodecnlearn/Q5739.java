package com.yuren.leetcodecnlearn;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2021-05-02 23:09
 */
public class Q5739 {
    public String replaceDigits(String s) {
        StringBuilder s1 = new StringBuilder();
        char[] c = s.toCharArray();
        for (int i = 0; i < c.length; i++) {
            if (i % 2 == 0) {
                s1.append(c[i]);
            } else {
                s1.append((char) (c[i - 1] + (c[i] - '0')));
            }
        }
        return s1.toString();
    }
}

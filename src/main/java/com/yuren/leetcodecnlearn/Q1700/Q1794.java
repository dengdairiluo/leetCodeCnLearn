package com.yuren.leetcodecnlearn.Q1700;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-07-24 23:11
 */
public class Q1794 {
    public int countQuadruples(String firstString, String secondString) {
        int out = 0;
        int[] temp = new int[26];
        int len = secondString.length();
        for (int i = 0; i < len; i++) {
            temp[secondString.charAt(i) - 'a'] = i + 1;
        }
        int min = 10000000;
        len = firstString.length();
        for (int i = 0; i < len; i++) {
            int idx = temp[firstString.charAt(i) - 'a'];
            if (idx != 0) {
                if (i - idx < min) {
                    out = 1;
                    min = i - idx;
                } else if (i - idx == min) {
                    out++;
                }
            }
        }
        return out;
    }
}

package com.yuren.leetcodecnlearn.Q1700;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-07-10 23:48
 */
public class Q1758 {
    public int minOperations(String s) {
        char[] cs = s.toCharArray();
        int ze = 0, one = 0;
        boolean zf = true, zo = false;
        for (int i = 0; i < cs.length; i += 2) {
            if (cs[i] != '0') {
                ze++;
            } else {
                one++;
            }
        }
        for (int i = 1; i < cs.length; i += 2) {
            if (cs[i] != '1') {
                ze++;
            } else {
                one++;
            }
        }
        return Math.min(one, ze);
    }
}

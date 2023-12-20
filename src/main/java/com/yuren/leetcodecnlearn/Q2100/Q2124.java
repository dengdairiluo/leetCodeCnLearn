package com.yuren.leetcodecnlearn.Q2100;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-12-20 23:24
 */
public class Q2124 {
    public boolean checkString(String s) {
        int lastA = -1, firstB = -1;
        int length = s.length();
        for (int i = 0; i < length; i++) {
            if (s.charAt(i) == 'a') {
                lastA = i;
            } else if (firstB < 0) {
                firstB = i;
            }
        }
        return firstB < 0 || lastA < 0 || lastA < firstB;
    }
}

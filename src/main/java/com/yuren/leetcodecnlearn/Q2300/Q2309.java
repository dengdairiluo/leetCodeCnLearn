package com.yuren.leetcodecnlearn.Q2300;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-03-21 23:29
 */
public class Q2309 {
    public String greatestLetter(String s) {
        int a = 'A', z = 'Z';
        int LOWER = 32;
        for (int i = z; i >= a; i--) {
            if (s.indexOf((char) i) >= 0 && s.indexOf((char) (i + LOWER)) >= 0) {
                return String.valueOf((char) i);
            }
        }
        return "";
    }
}

package com.yuren.leetcodecnlearn.Q1000;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-09-14 23:46
 */
public class Q1003 {
    public boolean isValid(String s) {
        char[] cs = new char[s.length() + 2];
        int i = 2;
        for (char c : s.toCharArray()) {
            if (c == 'a') cs[i++] = c;
            else if (c == 'b') {
                if (cs[i - 1] != 'a') return false;
                cs[i++] = c;
            } else {
                if (cs[i - 1] != 'b' || cs[i - 2] != 'a') return false;
                i -= 2;
            }
        }
        return i == 2;
    }
}

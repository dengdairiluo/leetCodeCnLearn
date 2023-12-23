package com.yuren.leetcodecnlearn.Q2100;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-12-23 22:40
 */
public class Q2129 {
    public String capitalizeTitle(String title) {
        char[] s = title.toCharArray();
        int n = s.length;
        for (int i = 0; i < n; i++) {
            int t = i;
            while (i < n && s[i] != ' ') {
                s[i] |= ' ';
                i++;
            }
            if (i - t > 2) {
                s[t] &= '_';
            }
        }
        return new String(s);
    }
}

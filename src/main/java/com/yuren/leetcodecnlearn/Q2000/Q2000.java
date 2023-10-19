package com.yuren.leetcodecnlearn.Q2000;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-10-19 23:32
 */
public class Q2000 {
    public String reversePrefix(String word, char ch) {
        char[] cs = word.toCharArray();
        int n = cs.length, idx = -1;
        for (int i = 0; i < n && idx == -1; i++) {
            if (cs[i] == ch) idx = i;
        }
        int l = 0, r = idx;
        while (l < r) {
            char c = cs[l];
            cs[l++] = cs[r];
            cs[r--] = c;
        }
        return String.valueOf(cs);
    }
}

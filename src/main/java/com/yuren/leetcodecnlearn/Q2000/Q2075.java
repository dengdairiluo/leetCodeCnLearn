package com.yuren.leetcodecnlearn.Q2000;

import java.util.Arrays;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-11-25 22:27
 */
public class Q2075 {
    public String decodeCiphertext(String s, int nrows) {
        final int n = s.length();
        if (n == 0 || nrows == 1) {
            return s;
        }
        int counter = 0;
        for (char c : s.toCharArray()) {
            if ('a' <= c && c <= 'z') {
                counter++;
            }
        }
        char[] chars = new char[s.length()];
        int ncols = n / nrows;
        int r = 0, c = 0, cur = 0;
        int cnt = 0;
        int i = 0;
        while (true) {
            int index = r * ncols + c;
            char ch = s.charAt(index);
            chars[cnt++] = ch;
            if ('a' <= ch && ch <= 'z') {
                i++;
                if (i == counter) {
                    break;
                }
            }
            r++;
            c++;
            if (r == nrows || c == ncols) {
                r = 0;
                c = cur + 1;
                cur++;
            }
        }
        return String.valueOf(Arrays.copyOfRange(chars, 0, cnt));
    }
}

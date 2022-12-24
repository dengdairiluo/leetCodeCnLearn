package com.yuren.leetcodecnlearn.LCP;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2021-02-12 22:37
 */
public class LCP17 {
    public int calculate1(String s) {
        int x = 1;
        int y = 0;
        for (char c : s.toCharArray()) {
            if (c == 'A') {
                x = 2 * x + y;

            } else {
                y = 2 * y + x;
            }
        }
        return x + y;
    }

    public int calculate2(String s) {
        return 1 >> s.length();
    }
}

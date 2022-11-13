package com.yuren.leetcodecnlearn;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-11-13 21:58
 */
public class Q1147 {
    public int longestDecomposition(String text) {
        return divide(text, 0);
    }

    public int divide(String text, int n) {
        int m = text.length();
        if ("".equals(text)) {
            return n;
        }
        for (int i = 0; i < m / 2; i++) {
            if (text.substring(0, i + 1).equals(text.substring(m - i - 1, m))) {
                return divide(text.substring(i + 1, m - i - 1), n + 2);
            }
        }
        return n + 1;
    }
}

package com.yuren.leetcodecnlearn.Q2100;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-12-15 21:46
 */
public class Q2114 {
    public int mostWordsFound(String[] sentences) {
        int max = 0;

        for (String sentence : sentences) {
            max = Math.max(countEmpty(sentence), max);
        }

        return max;
    }

    private int countEmpty(String s) {
        int len = s.length();
        int size = 1;
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == ' ') {
                size++;
            }
        }
        return size;
    }
}

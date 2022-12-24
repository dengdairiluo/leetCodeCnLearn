package com.yuren.leetcodecnlearn.Q1200;

import java.util.Arrays;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-11-21 23:48
 */
public class Q1160 {
    public int countCharacters(String[] words, String chars) {
        int[] charCount = new int[26];
        for (int i = 0; i < chars.length(); i++) {
            charCount[(int) (chars.charAt(i) - 'a')]++;
        }
        int len = 0;
        for (int i = 0; i < words.length; i++) {
            len = len + this.spell(words[i], charCount);
        }
        return len;
    }

    public int spell(String word, int[] charCount) {
        int[] copy = Arrays.copyOf(charCount, charCount.length);
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            copy[c - 'a']--;
            if (copy[c - 'a'] < 0) {
                return 0;
            }
        }
        return word.length();
    }
}

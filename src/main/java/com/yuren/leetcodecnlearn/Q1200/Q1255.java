package com.yuren.leetcodecnlearn.Q1200;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-01-06 00:01
 */
public class Q1255 {
    int[] countLetters = new int[26];
    int ans = 0;

    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        for (char c : letters) {
            countLetters[c - 'a']++;
        }

        dfs(words, score, 0, 0);

        return ans;
    }

    public void dfs(String[] words, int[] score, int curScore, int index) {
        if (index == words.length) {
            ans = Math.max(ans, curScore);
            return;
        }

        dfs(words, score, curScore, index + 1);

        char[] cw = words[index].toCharArray();
        int temp = 0;
        for (int i = 0; i < cw.length; i++) {
            if (countLetters[cw[i] - 'a'] == 0) {
                i--;
                while (i >= 0) {
                    countLetters[cw[i] - 'a']++;
                    i--;
                }
                return;
            }

            countLetters[cw[i] - 'a']--;
            temp += score[cw[i] - 'a'];
        }

        dfs(words, score, curScore + temp, index + 1);

        for (char c : cw) {
            countLetters[c - 'a']++;
        }
    }
}

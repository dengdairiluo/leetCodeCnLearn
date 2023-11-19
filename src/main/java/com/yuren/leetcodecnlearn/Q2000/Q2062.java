package com.yuren.leetcodecnlearn.Q2000;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-11-19 23:54
 */
public class Q2062 {
    int res = 0;

    public int countVowelSubstrings(String word) {
        if (word.length() < 5) {
            return res;
        }
        for (int i = 0; i < word.length(); i++) {
            dfs(word, i, new int[5]);
        }
        return res;
    }

    private void dfs(String word, int index, int[] map) {
        if (index == word.length()) {
            return;
        }
        char c = word.charAt(index);
        if (c != 'a' && c != 'e' && c != 'i'
                && c != 'o' && c != 'u') {
            return;
        }
        if (c == 'a') {
            map[0]++;
        } else if (c == 'e') {
            map[1]++;
        } else if (c == 'i') {
            map[2]++;
        } else if (c == 'o') {
            map[3]++;
        } else if (c == 'u') {
            map[4]++;
        }
        if (map[0] > 0 && map[1] > 0 && map[2] > 0
                && map[3] > 0 && map[4] > 0) {
            res += 1;
        }
        dfs(word, index + 1, map);
    }
}

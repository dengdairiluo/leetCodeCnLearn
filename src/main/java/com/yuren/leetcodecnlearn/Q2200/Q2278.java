package com.yuren.leetcodecnlearn.Q2200;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-03-06 23:38
 */
public class Q2278 {
    public int percentageLetter(String s, char letter) {
        int[] cnts = new int[26];
        for (char c : s.toCharArray()) cnts[c - 'a']++;
        int sum = 0;
        for (int i = 0; i < 26; i++) sum += cnts[i];
        return 100 * cnts[letter - 'a'] / sum;
    }
}

package com.yuren.leetcodecnlearn.Q1400;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2021-07-17 21:17
 */
public class Q1347 {
    public int minSteps(String s, String t) {
        int[] map = new int[26];
        for (char a : s.toCharArray()) {
            map[a - 'a']++;
        }
        for (char a : t.toCharArray()) {
            map[a - 'a']--;
        }
        int res = 0;
        for (int i = 0; i < 26; i++) {
            res += Math.abs(map[i]);
        }
        return res / 2;
    }
}

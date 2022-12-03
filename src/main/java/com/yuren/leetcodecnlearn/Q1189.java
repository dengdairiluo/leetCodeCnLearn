package com.yuren.leetcodecnlearn;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-12-04 00:37
 */
public class Q1189 {
    public int maxNumberOfBalloons(String text) {
        int[] map = new int[26];
        char[] cs = text.toCharArray();
        for (char c : cs) {
            map[c - 'a']++;
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < map.length; i++) {
            if (i + 'a' == 'b' || i + 'a' == 'a' || i + 'a' == 'n') {
                res = Math.min(res, map[i]);
            } else if (i + 'a' == 'l' || i + 'a' == 'o') {
                res = Math.min(res, map[i] / 2);
            }
        }
        return res;
    }
}

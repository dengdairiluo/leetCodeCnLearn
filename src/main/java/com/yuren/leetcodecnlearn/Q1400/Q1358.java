package com.yuren.leetcodecnlearn.Q1400;

import java.util.Arrays;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-02-08 23:46
 */
public class Q1358 {
    public int numberOfSubstrings(String s) {
        int[] map = new int[3];
        Arrays.fill(map, -1);
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            map[s.charAt(i) - 'a'] = i;
            int max = i;
            for (int j = 0; j < 3; j++) {
                max = Math.min(max, map[j]);
            }
            if (max == -1) {
                continue;
            }

            res += max + 1;
        }
        return res;
    }
}

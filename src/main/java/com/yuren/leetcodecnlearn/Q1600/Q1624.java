package com.yuren.leetcodecnlearn.Q1600;

import java.util.Arrays;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-05-21 23:46
 */
public class Q1624 {
    public int maxLengthBetweenEqualCharacters(String s) {
        char[] c = s.toCharArray();
        int[] idx = new int[26];
        Arrays.fill(idx, -1);
        int ans = -1;
        for (int i = 0; i < c.length; i++) {
            int a = c[i] - 'a';
            if (idx[a] == -1) {
                idx[a] = i;
            } else {
                ans = Math.max(ans, i - idx[a] - 1);
            }
        }
        return ans;
    }
}

package com.yuren.leetcodecnlearn.Q2000;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-11-29 23:22
 */
public class Q2083 {
    public long numberOfSubstrings(String s) {
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        long ans = 0;
        for (int i = 0; i < 26; ++i) {
            ans += (long) count[i] * (count[i] + 1) / 2;
        }
        return ans;
    }
}

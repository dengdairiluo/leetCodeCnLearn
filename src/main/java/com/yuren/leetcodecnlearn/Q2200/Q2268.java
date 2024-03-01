package com.yuren.leetcodecnlearn.Q2200;

import java.util.Arrays;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-03-01 23:16
 */
public class Q2268 {
    public int minimumKeypresses(String s) {
        // count frequency of each letter in s
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        // sort increasing. first indexes might be zero
        Arrays.sort(freq);

        //count key press. The First 9 high frequencies should be the first press, the second 9 high frequencies should be the second press, the third nine high frequency should be the third press
        int res = 0;
        for (int i = 25; i > 16; i--) {
            res += freq[i];
        }

        for (int i = 16; i > 7; i--) {
            res += freq[i] * 2;
        }

        for (int i = 7; i >= 0; i--) {
            res += freq[i] * 3;
        }

        return res;
    }
}

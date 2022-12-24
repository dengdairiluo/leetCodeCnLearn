package com.yuren.leetcodecnlearn.J;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2021-08-07 20:43
 */
public class J02005 {
    public int maxProduct(String[] words) {
        Arrays.sort(words, Comparator.comparing(String::length));
        final int max = 0x3FFFFFF;
        int[] hash = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            for (char c : words[i].toCharArray()) {
                hash[i] |= 1 << (c - 'a');
                if (hash[i] == max) {
                    break;
                }
            }
        }
        int bound = -1;
        int ans = 0;
        for (int i = words.length - 1; i > bound; i--) {
            for (int j = i - 1; j > bound; j--) {
                if ((hash[i] & hash[j]) == 0) {
                    bound = j;
                    ans = Math.max(ans, words[i].length() * words[j].length());
                    break;
                }
            }
        }
        return ans;

    }
}

package com.yuren.leetcodecnlearn.Q1100;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-10-02 23:53
 */
public class Q1048 {
    public int longestStrChain(String[] words) {
        Arrays.sort(words, Comparator.comparingInt(String::length));
        int n = words.length;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (isPredecessor(words[i], words[j])) {
                    dp[j] = Math.max(dp[i] + 1, dp[j]);
                }
            }
        }
        int res = 0;
        for (int i : dp) {
            res = Math.max(res, i);
        }
        return res + 1;
    }

    public boolean isPredecessor(String a, String b) {
        if (b.length() - a.length() != 1) {
            return false;
        }
        int flag = 0;
        int i = 0, j = 0;
        while (i < a.length() && j < b.length()) {
            if (a.charAt(i) == b.charAt(j)) {
                i++;
                j++;
            } else {
                flag++;
                j++;
                if (flag > 1) {
                    return false;
                }
            }
        }
        return true;
    }
}

package com.yuren.leetcodecnlearn.Q1500;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-04-18 23:42
 */
public class Q1540 {
    public boolean canConvertString(String s, String t, int k) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] counts = new int[26];
        int length = s.length();
        for (int i = 0; i < length; i++) {
            int difference = t.charAt(i) - s.charAt(i);
            if (difference < 0) {
                difference += 26;
            }
            counts[difference]++;
        }
        for (int i = 1; i < 26; i++) {
            int maxConvert = i + 26 * (counts[i] - 1);
            if (maxConvert > k) {
                return false;
            }
        }
        return true;
    }
}

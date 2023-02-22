package com.yuren.leetcodecnlearn.Q1500;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-02-23 01:00
 */
public class Q1400 {
    public boolean canConstruct(String s, int k) {
        int[] ch = new int[26];
        int min = 0;
        for (char c : s.toCharArray()) {
            ch[c - 'a'] ^= 1;
        }
        for (int count : ch) {
            min += count;
        }
        return k <= s.length() && k >= Math.max(min, 1);
    }
}

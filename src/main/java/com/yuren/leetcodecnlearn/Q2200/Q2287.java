package com.yuren.leetcodecnlearn.Q2200;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-03-10 23:08
 */
public class Q2287 {
    public int rearrangeCharacters(String s, String target) {
        int[] targetNum = new int[26];
        int[] sNum = new int[26];
        int count = Integer.MAX_VALUE / 2;
        for (int i = 0; i < target.length(); i++) {
            targetNum[target.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            sNum[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            int si = sNum[i];
            int ti = targetNum[i];
            if (ti != 0) {
                count = si >= ti ? Math.min(si / ti, count) : 0;
            }
        }
        return count;
    }
}

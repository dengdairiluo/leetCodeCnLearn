package com.yuren.leetcodecnlearn.Q2000;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-11-22 22:59
 */
public class Q2068 {
    public boolean checkAlmostEquivalent(String word1, String word2) {
        int[] res = new int[26];
        char[] cs = word1.toCharArray();
        char[] s = word2.toCharArray();
        for (int i = 0; i < word1.length(); i++) {
            res[cs[i] - 'a']++;
            res[s[i] - 'a']--;
        }
        boolean flag = true;
        for (int i : res) {
            if (i > 3) flag = false;
            if (i < -3) flag = false;
        }
        return flag;
    }
}

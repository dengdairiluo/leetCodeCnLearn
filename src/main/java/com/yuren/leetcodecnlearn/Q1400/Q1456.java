package com.yuren.leetcodecnlearn.Q1400;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-03-16 23:44
 */
public class Q1456 {
    public int maxVowels(String s, int k) {
        char[] chars = s.toCharArray();
        int r = 0, n = chars.length;
        boolean[] vowel = new boolean[123];
        vowel['a'] = vowel['e'] = vowel['i'] = vowel['o'] = vowel['u'] = true;
        int c = 0;
        while (r < k) {
            if (vowel[chars[r++]]) {
                c++;
            }
        }
        int ret = c;
        while (r < n) {

            if (vowel[chars[r - k]]) {
                c--;
            }
            if (vowel[chars[r++]]) {
                c++;
            }
            if (c > ret) {
                ret = c;
            }
        }
        return ret;
    }
}

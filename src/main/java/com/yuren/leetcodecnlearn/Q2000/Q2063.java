package com.yuren.leetcodecnlearn.Q2000;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-11-19 23:56
 */
public class Q2063 {
    static boolean[] vowels = new boolean['z' + 1];

    static {
        vowels['a'] = true;
        vowels['e'] = true;
        vowels['i'] = true;
        vowels['o'] = true;
        vowels['u'] = true;
    }

    public long countVowels(String word) {
        char[] chars = word.toCharArray();
        int n = chars.length;
        long res = 0;
        for (int i = 0; i < n; i++) {
            if (vowels[chars[i]]) {
                res += (long) (i + 1) * (n - i);
            }
        }
        return res;
    }
}

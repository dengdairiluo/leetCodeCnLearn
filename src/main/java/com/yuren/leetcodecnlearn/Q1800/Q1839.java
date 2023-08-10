package com.yuren.leetcodecnlearn.Q1800;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-08-10 23:54
 */
public class Q1839 {
    public int longestBeautifulSubstring(String words) {
        int res = 0;
        int len = words.length();
        int p = 0;
        char[] word = words.toCharArray();

        while (p < len) {
            int i = p;
            if (i < len && word[i] == 'a') {
                while (i < len && word[i] == 'a') i++;
                if (i < len && word[i] == 'e') {
                    while (i < len && word[i] == 'e') i++;
                    if (i < len && word[i] == 'i') {
                        while (i < len && word[i] == 'i') i++;
                        if (i < len && word[i] == 'o') {
                            while (i < len && word[i] == 'o') i++;
                            if (i < len && word[i] == 'u') {
                                while (i < len && word[i] == 'u') i++;
                                res = Math.max(res, i - p);
                            }
                        }
                    }
                }
            }
            p = i;
            while (p < len && word[p] != 'a') p++;


        }
        return res;
    }
}

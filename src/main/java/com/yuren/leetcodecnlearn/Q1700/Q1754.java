package com.yuren.leetcodecnlearn.Q1700;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-07-09 23:24
 */
public class Q1754 {
    public String largestMerge(String word1, String word2) {
        StringBuilder builder = new StringBuilder();
        char[] chars1 = word1.toCharArray();
        char[] chars2 = word2.toCharArray();
        int i = 0;
        int j = 0;
        while (i < chars1.length && j < chars2.length) {
            if (chars1[i] > chars2[j]) {
                builder.append(chars1[i++]);
            } else if (chars1[i] < chars2[j]) {
                builder.append(chars2[j++]);
            } else { // 两个值相等，则比较后面的字符
                int x = i;
                int y = j;
                while (x < word1.length() && y < word2.length() && chars1[x] == chars2[y]) {
                    x++;
                    y++;
                }
                if (x == word1.length() || (y < word2.length() && chars1[x] < chars2[y])) {
                    builder.append(chars2[j++]);
                } else {
                    builder.append(chars1[i++]);
                }
            }
        }
        if (i < word1.length()) {
            builder.append(word1.substring(i));
        }
        if (j < word2.length()) {
            builder.append(word2.substring(j));
        }
        return builder.toString();
    }
}

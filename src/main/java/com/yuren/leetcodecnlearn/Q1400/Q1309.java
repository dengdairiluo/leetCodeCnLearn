package com.yuren.leetcodecnlearn.Q1400;

public class Q1309 {
    public String freqAlphabets(String s) {
        char[] alphabetChars = new char[27];
        for (int i = 1; i < alphabetChars.length; i++) {
            alphabetChars[i] = (char) (96 + i);
        }
        StringBuilder builder = new StringBuilder();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (i < chars.length - 2 && chars[i + 2] == '#') {
                builder.append(alphabetChars[(chars[i] - '0') * 10 + (chars[i + 1] - '0')]);
                i += 2;
            } else {
                builder.append(alphabetChars[chars[i] - '0']);
            }
        }
        return builder.toString();
    }
}

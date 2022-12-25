package com.yuren.leetcodecnlearn.Q1400;

import java.util.Arrays;

public class Q1374 {
    public String generateTheString1(int n) {
        char[] cs = new char[n];
        Arrays.fill(cs, 'a');
        if (n % 2 == 0) {
            cs[0] = 'b';
        } else {
            cs[0] = 'a';
        }
        for (int i = 1; i < n; i++) {
            cs[i] = 'a';
        }

        return new String(cs);

    }

    public String generateTheString2(int n) {
        StringBuilder builder = new StringBuilder();
        if (n % 2 == 0) {
            builder.append('b');
        } else {
            builder.append('a');
        }
        for (int i = 0; i < n - 1; i++) {
            builder.append('a');
        }
        return builder.toString();
    }
}

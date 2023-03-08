package com.yuren.leetcodecnlearn.Q1700;

public class Q1704 {

    public boolean halvesAreAlike(String s) {
        int n = s.length();
        int a = 0, b = 0;
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' ||
                    ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U') {
                if (i < (n / 2)) {
                    a++;
                } else {
                    b++;
                }
            }

        }
        return a == b;
    }

}

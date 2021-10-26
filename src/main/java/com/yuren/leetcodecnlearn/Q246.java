package com.yuren.leetcodecnlearn;

public class Q246 {
    public boolean isStrobogrammatic(String num) {
        char[] reverse = new char[]{'0', '1', 'a', 'a', 'a', 'a', '9', 'a', '8', '6'};
        char[] s = num.toCharArray();

        int l = 0, r = s.length - 1;
        while (l <= r) {
            if (reverse[s[l] - '0'] != s[r]) {
                return false;
            }
            l++;
            r--;
        }

        return true;
    }

}

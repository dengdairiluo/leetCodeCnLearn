package com.yuren.leetcodecnlearn;

public class Q1816 {

    private static String truncateSentence1(String s, int k) {
        int len = s.length();
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == ' ') {
                k--;
                if (k == 0) {
                    return s.substring(0, i);
                }
            }
        }
        return s;
    }

    private static String truncateSentence2(String s, int k) {
        int len = s.length();
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == ' ' && --k == 0) {
                return s.substring(0, i);
            }
        }
        return s;
    }

    public static void main(String[] args) {

    }

}

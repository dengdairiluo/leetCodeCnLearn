package com.yuren.leetcodecnlearn;

public class Q5685 {

    private static String mergeAlternately(String word1, String word2) {
        int n = Math.min(word1.length(), word2.length());

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            builder.append(word1.charAt(i));
            builder.append(word2.charAt(i));
        }

        while (n < word1.length()) {
            builder.append(word1.charAt(n));
            n++;
        }
        while (n < word2.length()) {
            builder.append(word2.charAt(n));
            n++;
        }
        return builder.toString();
    }


    public static void main(String[] args) {
        String word1 = "abc";
        String word2 = "xyz";
        System.out.println(mergeAlternately(word1, word2));
    }
}

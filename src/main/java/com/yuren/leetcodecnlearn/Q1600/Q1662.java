package com.yuren.leetcodecnlearn.Q1600;

public class Q1662 {

    public boolean arrayStringsAreEqual1(String[] word1, String[] word2) {
        StringBuilder builder1 = new StringBuilder();

        for (String w1 : word1) {
            builder1.append(w1);
        }

        StringBuilder builder2 = new StringBuilder();
        for (String w2 : word2) {
            builder2.append(w2);
        }

        return builder1.toString().equals(builder2.toString());
    }

    public boolean arrayStringsAreEqual2(String[] word1, String[] word2) {
        return String.join("", word1).equals(String.join("", word2));
    }
}

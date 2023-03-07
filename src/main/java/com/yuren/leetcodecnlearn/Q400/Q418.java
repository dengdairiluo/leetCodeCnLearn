package com.yuren.leetcodecnlearn.Q400;

public class Q418 {
    public int wordsTyping(String[] sentence, int rows, int cols) {
        int n = sentence.length, wordIndex = 0;
        int[] len = new int[n];
        for (int i = 0; i < n; i++) {
            len[i] = sentence[i].length();
        }
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            wordIndex = i;
            int currRowLen = 0, times = 0;
            while (currRowLen + len[wordIndex] <= cols) {
                currRowLen += len[wordIndex++] + 1;
                if (wordIndex == n) {
                    wordIndex = 0;
                    times++;
                }
            }
            dp[i] = wordIndex + times * 100;
        }
        int index = 0, res = 0;
        wordIndex = 0;
        while (index < rows) {
            index++;
            res += dp[wordIndex] / 100;
            wordIndex = dp[wordIndex] % 100;
        }
        return res;
    }
}

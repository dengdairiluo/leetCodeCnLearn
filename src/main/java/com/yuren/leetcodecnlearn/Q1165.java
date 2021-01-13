package com.yuren.leetcodecnlearn;

public class Q1165 {

    public int calculateTime(String keyboard, String word) {
        int[] hash = new int[26];
        for (int i = 0; i < keyboard.length(); i++) {
            hash[keyboard.charAt(i) - 97] = i;
        }

        int cnt = 0;
        int pre = 0;
        for (int i = 0; i < word.length(); i++) {
            int now = hash[word.charAt(i) - 97];
            if (now >= pre) {
                cnt += now - pre;
            } else {
                cnt += pre - now;
            }
            pre = now;
        }
        return cnt;
    }

}

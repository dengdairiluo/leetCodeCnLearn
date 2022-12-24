package com.yuren.leetcodecnlearn.Q1200;

public class Q1180 {

    private static int countLetters(String S) {
        int len = S.length();
        int ans = 0;
        int cnt = 1;
        for (int i = 1; i < len; i++) {
            if (S.charAt(i - 1) == S.charAt(i)) {
                cnt++;
            } else {
                ans += cnt * (cnt + 1) / 2;
                cnt = 1;
            }
        }
        ans += cnt * (cnt + 1) / 2;
        return ans;
    }

    public static void main(String[] args) {
//        System.out.println(countLetters("aaaba"));
        System.out.println(countLetters("aaaaaaaaaa"));
    }
}

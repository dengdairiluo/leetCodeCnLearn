package com.yuren.leetcodecnlearn.Q1300;

public class Q1221 {

    private static int balancedStringSplit1(String s) {
        int ans = 0;

        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'L') {
                cnt++;
            } else {
                cnt--;
            }
            if (cnt == 0) {
                ans++;
            }
        }
        return ans;
    }

    private static int balancedStringSplit2(String s) {
        int ans = 0;

        int cnt = 0;

        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (c == 'L') {
                cnt++;
            } else {
                cnt--;
            }
            if (cnt == 0) {
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "RLRRLLRLRL";
        System.out.println(balancedStringSplit1(s));
    }
}

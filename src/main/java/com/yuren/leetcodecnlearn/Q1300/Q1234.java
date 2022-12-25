package com.yuren.leetcodecnlearn.Q1300;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-12-26 05:56
 */
public class Q1234 {
    public int balancedString(String s) {
        int[] cnt = new int[26];
        char[] chars = s.toCharArray();
        for (char c : chars) {
            cnt[c - 'A']++;
        }
        int len = s.length();
        int l = 0, r = 0;
        int ans = len;
        int targetQ = Math.max(0, cnt['Q' - 'A'] - len / 4);
        int targetW = Math.max(0, cnt['W' - 'A'] - len / 4);
        int targetE = Math.max(0, cnt['E' - 'A'] - len / 4);
        int targetR = Math.max(0, cnt['R' - 'A'] - len / 4);
        if (targetQ == 0 && targetW == 0 && targetE == 0 && targetR == 0)
            return 0;
        int[] cur = new int[26];
        while (r < len) {
            cur[chars[r] - 'A']++;
            while (l <= r && cur['Q' - 'A'] >= targetQ && cur['W' - 'A'] >= targetW
                    && cur['E' - 'A'] >= targetE && cur['R' - 'A'] >= targetR) {
                ans = Math.min(ans, r - l + 1);
                cur[chars[l++] - 'A']--;
            }
            r++;
        }
        return ans;
    }
}

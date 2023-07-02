package com.yuren.leetcodecnlearn.Q1700;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-07-02 23:12
 */
public class Q1737 {
    public int minCharacters(String a, String b) {
        int n = a.length(), m = b.length(), ans = 0x3f3f3f3f;
        int[] c1 = new int[26], c2 = new int[26];
        for (char c : a.toCharArray()) {
            c1[c - 'a']++;
        }
        for (char c : b.toCharArray()) {
            c2[c - 'a']++;
        }
        for (int i = 0; i < 26 && ans != 0; i++) {
            // 3
            int ca = n - c1[i], cb = m - c2[i];
            ans = Math.min(ans, ca + cb);
            if (i == 0) {
                continue;
            }
            int r1 = 0, r2 = 0;
            // 1
            for (int j = i; j < 26; j++) {
                r1 += c1[j];
            }
            for (int j = 0; j < i; j++) {
                r1 += c2[j];
            }
            // 2
            for (int j = i; j < 26; j++) {
                r2 += c2[j];
            }
            for (int j = 0; j < i; j++) {
                r2 += c1[j];
            }
            ans = Math.min(ans, Math.min(r1, r2));
        }
        return ans;
    }
}

package com.yuren.leetcodecnlearn.Q1700;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-07-16 23:23
 */
public class Q1771 {
    public int longestPalindrome(String word1, String word2) {
        int n = word1.length() + word2.length(), ans = 0;
        String s = word1 + word2;
        char[] c = s.toCharArray();
        int[] f = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            f[i] = 1;
            int pre = 0;
            for (int j = i + 1; j < n; j++) {
                int t = f[j];
                if (c[i] == c[j]) {
                    f[j] = pre + 2;
                    if (i < word1.length() && j >= word1.length()) {
                        ans = Math.max(ans, f[j]);
                    }
                } else {
                    f[j] = Math.max(f[j - 1], f[j]);
                }
                pre = t;
            }
        }
        return ans;
    }
}

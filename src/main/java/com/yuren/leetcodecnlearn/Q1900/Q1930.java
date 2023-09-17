package com.yuren.leetcodecnlearn.Q1900;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-09-17 20:25
 */
public class Q1930 {
    public int countPalindromicSubsequence(String s) {

        int ans = 0;
        char[] cs = s.toCharArray();
        int N = cs.length;
        // left[i] i及其左边出现过的字符种类
        int[] left = new int[N];
        int[] right = new int[N];
        left[0] = 1 << (cs[0] - 'a');
        right[N - 1] = 1 << (cs[N - 1] - 'a');
        for (int i = 1; i < N; i++) {
            left[i] = left[i - 1] | 1 << (cs[i] - 'a');
        }
        for (int i = N - 2; i >= 0; i--) {
            right[i] = right[i + 1] | 1 << (cs[i] - 'a');
        }

        int[] count = new int[26];
        for (int i = 1; i < N - 1; i++) {
            // left[i - 1] & right[i + 1] 左右都出现过的
            count[cs[i] - 'a'] |= left[i - 1] & right[i + 1];
        }

        for (int i = 0; i < 26; i++) {
            ans += Integer.bitCount(count[i]);
        }
        return ans;
    }
}

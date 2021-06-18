package com.yuren.leetcodecnlearn;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2021-06-18 23:49
 */
public class Q821 {
    public int[] shortestToChar(String s, char c) {
        int N = s.length();
        int[] ans = new int[N];
        int prev = Integer.MIN_VALUE / 2;

        for (int i = 0; i < N; ++i) {
            if (s.charAt(i) == c) prev = i;
            ans[i] = i - prev;
        }

        prev = Integer.MAX_VALUE / 2;
        for (int i = N - 1; i >= 0; --i) {
            if (s.charAt(i) == c) prev = i;
            ans[i] = Math.min(ans[i], prev - i);
        }

        return ans;
    }
}

package com.yuren.leetcodecnlearn.Q2300;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-04-24 上午1:04
 */
public class Q2370 {
    public int longestIdealString(String s, int k) {
        if (k == 25) return s.length();
        int[] dp = new int[26];
        int ans = 0;
        char[] chars = s.toCharArray();
        for (char c : chars) {
            int cv = c - 'a';
            int start = Math.max(cv - k, 0);
            int end = Math.min(cv + k, 25);
            int best = 0;
            for (; start <= end; start++) {
                best = Math.max(best, dp[start]);
            }
            dp[cv] = best + 1;
        }
        for (int v : dp) ans = Math.max(v, ans);
        return ans;
    }
}

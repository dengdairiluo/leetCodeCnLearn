package com.yuren.leetcodecnlearn.Q2000;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-11-14 23:18
 */
public class Q2052 {
    public int minimumCost(String sentence, int k) {
        if (sentence.length() <= k) return 0;
        String[] word = sentence.split(" ");
        int n = word.length;
        int[] dp = new int[n];
        dp[0] = (k - word[0].length()) * (k - word[0].length());
        for (int i = 1; i < n; i++) {
            int len = 0;
            dp[i] = Integer.MAX_VALUE;
            for (int j = i; j >= 1; j--) {
                len += word[j].length();
                if (len <= k)
                    dp[i] = Math.min(dp[i], dp[j - 1] + (k - len) * (k - len));
                else break;
                len++;
            }
            len += word[0].length();
            if (len <= k) dp[i] = Math.min(dp[i], (k - len) * (k - len));
        }
        int ans = Integer.MAX_VALUE / 2;
        int s = 0;
        for (int i = n - 1; i >= 0; i--) {
            s += word[i].length();
            if (s <= k) ans = Math.min(ans, dp[i - 1]);
            else break;
            s++;
        }
        return ans;
    }
}

package com.yuren.leetcodecnlearn.Q1900;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-10-15 00:01
 */
public class Q1987 {
    public int numberOfUniqueGoodSubsequences(String binary) {
        int in = binary.indexOf('1');
        if (in == -1) return 1;
        binary = binary.substring(in);
        char[] chs = binary.toCharArray();
        int len = chs.length;
        int[] dp = new int[2];
        int n = in > 0 ? 1 : 0, mod = (int) 1e9 + 7;
        for (char ch : chs) {
            if (ch == '0') {
                dp[0] = (dp[0] + dp[1]) % mod;
                n = 1;
            } else dp[1] = (dp[0] + dp[1] + 1) % mod;
        }
        return (dp[0] + dp[1] + n) % mod;
    }
}

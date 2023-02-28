package com.yuren.leetcodecnlearn.Q1500;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-02-28 23:03
 */
public class Q1416 {
    public int numberOfArrays(String s, int k) {
        int MOD = 1000000007;
        char[] chars = s.toCharArray();
        long[] dp = new long[chars.length + 1];
        dp[chars.length] = 1;
        for (int i = chars.length - 1; i >= 0; i--) {
            long sum = 0, cur = 0;
            if (chars[i] == '0') {
                continue;
            }
            for (int j = i; j < chars.length && j < i + 10; j++) {
                cur = cur * 10 + chars[j] - '0';
                if (cur <= k) {
                    sum += dp[j + 1];
                } else {
                    break;
                }
            }
            dp[i] = sum % MOD;
        }
        return (int) (dp[0] % MOD);
    }
}

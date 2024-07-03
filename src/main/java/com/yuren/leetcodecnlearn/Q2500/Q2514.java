package com.yuren.leetcodecnlearn.Q2500;

import java.util.Arrays;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-07-03 下午11:43
 */
public class Q2514 {
    private static final int MOD = (int) 1e9 + 7;

    public int countAnagrams(String S) {
        char[] s = S.toCharArray();
        long ans = 1L, mul = 1L;
        int[] cnt = new int[26];
        for (int i = 0, j = 0; i < s.length; ++i) {
            if (s[i] == ' ') {
                Arrays.fill(cnt, 0);
                j = 0;
            } else {
                mul = mul * ++cnt[s[i] - 'a'] % MOD;
                ans = ans * ++j % MOD;
            }
        }
        return (int) (ans * pow(mul, MOD - 2) % MOD);
    }

    private long pow(long x, int n) {
        long res = 1L;
        for (; n > 0; n /= 2) {
            if (n % 2 > 0) res = res * x % MOD;
            x = x * x % MOD;
        }
        return res;
    }
}

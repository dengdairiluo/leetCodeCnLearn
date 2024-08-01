package com.yuren.leetcodecnlearn.Q2500;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-08-01 下午11:58
 */
public class Q2572 {
    static int[] primes = new int[]{2, 3, 5, 7, 11, 13, 17, 19, 23, 29};
    static int mod = (int) 1e9 + 7, mx = 30, n_primes = primes.length, m = 1 << n_primes;
    static int[] sf_to_mask = new int[mx + 1];

    static {
        for (int i = 2; i <= mx; i++) {
            for (int j = 0; j < n_primes; j++) {
                int p = primes[j];
                if (i % p == 0) {
                    if (i % (p * p) == 0) {
                        sf_to_mask[i] = -1;
                        break;
                    }
                    sf_to_mask[i] |= 1 << j;
                }
            }
        }
    }

    public int squareFreeSubsets(int[] nums) {
        int[] cnt = new int[mx + 1];
        int pow2 = 1;
        for (int x : nums) {
            if (x == 1) pow2 = pow2 * 2 % mod;
            else cnt[x]++;
        }
        long[] dp = new long[m];
        dp[0] = pow2;
        for (int x = 2; x <= mx; x++) {
            int mask = sf_to_mask[x], c = cnt[x];
            if (mask > 0 && c > 0) {
                int other = (m - 1) ^ mask, j = other;
                do {
                    dp[j | mask] = (dp[j | mask] + dp[j] * cnt[x]) % mod;
                    j = (j - 1) & other;
                } while (j != other);
            }
        }
        long res = -1;
        for (long x : dp) res += x;
        return (int) (res % mod);
    }
}

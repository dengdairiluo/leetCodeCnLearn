package com.yuren.leetcodecnlearn.Q1900;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-10-08 23:40
 */
public class Q1969 {
    private final long MOD = (long) (1e9 + 7);

    public int minNonZeroProduct(int p) {
        long max_num = (1L << p) - 1;

        long x = max_num - 1;
        long n = (1L << (p - 1)) - 1;

        long res = max_num % MOD * quick_mul(x, n) % MOD;
        return (int) res;
    }

    public long quick_mul(long x, long n) {
        x %= MOD;
        long res = 1L;
        while (n > 0) {
            if ((n & 1) != 0)
                res = (res * x) % MOD;
            x = (x * x) % MOD;
            n >>= 1;
        }
        return res;
    }
}

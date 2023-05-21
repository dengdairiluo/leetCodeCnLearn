package com.yuren.leetcodecnlearn.Q1600;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-05-21 23:38
 */
public class Q1621 {
    private static final int mod = (int) 1e9 + 7;

    public int numberOfSets(int n, int k) {

        return com(n + k - 1, k * 2);
    }

    private int com(int n, int k) {
        if (n < k) {
            return 0;
        }

        long a = 1;
        long b = 1;
        for (int i = 0; i < k; i++) {
            a *= n - i;
            a %= mod;

            b *= i + 1;
            b %= mod;
        }

        return (int) modDivision(a, b, mod);
    }

    private long modDivision(long a, long b, long m) {
        a %= m;
        long inv = modInverse(b, m);
        if (inv == -1) {
            // division not defined
            return 0;
        }

        return (inv * a) % m;
    }

    private long modInverse(long a, long m) {

        long gcd = gcd(a, m);
        if (gcd != 1) {
            // a and m are not co-prime
            return -1;
        }

        return power(a, m - 2, m);
    }

    private long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    private long power(long x, long y, long m) {
        if (y == 0) {
            return 1;
        }
        long p = power(x, y / 2, m) % m;
        p = (p * p) % m;
        return y % 2 == 0 ? p : (x * p) % m;
    }
}

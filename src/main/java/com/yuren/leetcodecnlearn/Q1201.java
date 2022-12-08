package com.yuren.leetcodecnlearn;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-12-08 23:51
 */
public class Q1201 {
    public int nthUglyNumber(int n, int a, int b, int c) {
        long ans = 0;
        long l = 0, r = (long) Math.min(a, Math.min(b, c)) * n;
        long ab = this.lcm(a, b);
        long ac = this.lcm(a, c);
        long bc = this.lcm(b, c);
        long abc = this.lcm(b, ac);
        while (l <= r) {
            long m = l + ((r - l) >> 1);
            long N = m / a + m / b + m / c - m / ab - m / ac - m / bc + m / abc;
            if (N < n) {
                l = m + 1;
                ans = l;
            } else {
                r = m - 1;
            }
        }
        return (int) ans;
    }

    private long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    private long lcm(long a, long b) {
        return a * b / gcd(a, b);
    }
}

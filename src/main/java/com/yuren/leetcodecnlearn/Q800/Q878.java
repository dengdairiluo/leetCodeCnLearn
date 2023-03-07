package com.yuren.leetcodecnlearn.Q800;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-07-22 21:15
 */
public class Q878 {
    public int nthMagicalNumber(int N, int A, int B) {
        int mod = 1_000_000_007;
        int l = A / gcd(A, B) * B;

        long lo = 0;
        long hi = (long) 1e15;
        while (lo < hi) {
            long mi = lo + (hi - lo) / 2;
            // If there are not enough magic numbers below mi...
            if (mi / A + mi / B - mi / l < N)
                lo = mi + 1;
            else
                hi = mi;
        }

        return (int) (lo % mod);
    }

    public int gcd(int x, int y) {
        if (x == 0) {
            return y;
        }
        return gcd(y % x, x);
    }
}

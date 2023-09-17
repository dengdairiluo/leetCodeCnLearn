package com.yuren.leetcodecnlearn.Q1900;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-09-17 20:19
 */
public class Q1928 {
    public int minCost(int maxTime, int[][] edges, int[] passingFees) {
        int n = passingFees.length + 1, i, j, z1, z2, len, g[] = new int[n];
        for (int[] e : edges) {
            ++g[e[0]];
            ++g[e[1]];
        }
        for (i = 0, j = g[0]; ++i < n; g[i] = j += g[i]) ;
        long a[] = new long[j], b[] = new long[512], x1, x2, x3, x4, x5;
        for (int[] e : edges) {
            z1 = e[0];
            z2 = e[1];
            x3 = e[2];
            x3 <<= 10;
            x4 = passingFees[z1];
            x5 = passingFees[z2];
            x4 <<= 32;
            x5 <<= 32;
            x5 += z2 + x3;
            x4 += z1 + x3;
            a[--g[z1]] = x5;
            a[--g[z2]] = x4;
        }
        for (x1 = passingFees[0], x1 <<= 32, --n, z1 = maxTime << 10, i = 0; ++i < n; passingFees[i] = z1) ;
        for (passingFees[0] = len = 0, passingFees[--n] += 1024; len >= 0; b[z1] = x2, --len) {
            for (x1 -= i = (int) (x1 & 1023), j = g[i], i = g[i + 1]; j < i; ++j) {
                x2 = x1 + a[j];
                z1 = z2 = (int) x2;
                z2 &= 1023;
                if (z1 >= passingFees[z2]) continue;
                if (z2 == n) return (int) (x2 >> 32);
                for (passingFees[z2] = z1, z1 = ++len; x2 < b[z1 >> 1]; b[z1] = b[z1 >>= 1]) ;
                b[z1] = x2;
            }
            for (x1 = b[1], x2 = b[len], z1 = 1, z2 = 2; z2 < len; z2 += z2) {
                x3 = b[z2];
                x4 = b[z2 + 1];
                if (x3 > x4) {
                    ++z2;
                    x3 = x4;
                }
                if (x2 <= x3) break;
                b[z1] = x3;
                z1 = z2;
            }
        }
        return -1;
    }
}

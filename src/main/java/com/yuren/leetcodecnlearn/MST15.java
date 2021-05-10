package com.yuren.leetcodecnlearn;

public class MST15 {

    public int hammingWeight1(int n) {
        return Integer.bitCount(n);
    }

    public int hammingWeight2(int n) {
        int res = 0;
        while (n != 0) {
            res += n & 1;
            n >>>= 1;
        }
        return res;
    }

    public int hammingWeight3(int n) {
        int res = 0;
        while (n != 0) {
            res++;
            n &= n - 1;
        }
        return res;
    }
}

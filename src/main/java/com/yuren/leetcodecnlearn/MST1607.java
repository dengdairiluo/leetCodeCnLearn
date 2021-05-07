package com.yuren.leetcodecnlearn;

public class MST1607 {
    public int maximum1(int a, int b) {
        return Math.max(a, b);
    }

    public int maximum2(int a, int b) {
        long x = (long) a - (long) b;
        int k = (int) (x >> 63);

        return (1 + k) * a - b * k;
    }


}

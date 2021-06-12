package com.yuren.leetcodecnlearn;

public class MST0507 {
    public int exchangeBits1(int num) {
        int left = num << 1;
        int right = num >> 1;
        int one = 1, two = 2, leftt = 0, rightt = 0;
        for (int i = 0; i < 16; i++) {
            leftt |= two;
            rightt |= one;
            one <<= 2;
            two <<= 2;
        }
        left &= leftt;
        right &= rightt;
        return left | right;

    }

    public int exchangeBits(int num) {
        return ((num & 0x55555555) << 1) | ((num & 0xaaaaaaaa) >> 1);
    }

}

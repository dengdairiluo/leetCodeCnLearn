package com.yuren.leetcodecnlearn;

public class Q564 {
    public int hammingDistance(int x, int y) {
        return Integer.bitCount(x ^ y);
    }
}

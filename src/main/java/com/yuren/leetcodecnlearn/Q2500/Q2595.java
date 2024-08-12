package com.yuren.leetcodecnlearn.Q2500;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-08-12 23:32
 */
public class Q2595 {
    static final int EVEN_MASK = 0x55555555, ODD_MASK = 0xaaaaaaaa;

    public int[] evenOddBit(int n) {
        return new int[]{bitCount(n & EVEN_MASK), bitCount(n & ODD_MASK)};
    }

    public int bitCount(int m) {
        m = m - ((m >>> 1) & 0x55555555);
        m = (m & 0x33333333) + ((m >>> 2) & 0x33333333);
        m = (m + (m >>> 4)) & 0x0f0f0f0f;
        m = (m + (m >>> 8)) & 0x00ff00ff;
        m = (m + (m >>> 16)) & 0x0000ffff;
        return m;
    }
}

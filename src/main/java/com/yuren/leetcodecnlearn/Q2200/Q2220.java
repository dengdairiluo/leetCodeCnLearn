package com.yuren.leetcodecnlearn.Q2200;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-02-06 23:18
 */
public class Q2220 {
    public int minBitFlips(int start, int goal) {
        int flips = 0;
        int xor = start ^ goal;
        while (xor != 0) {
            xor &= xor - 1;
            flips++;
        }
        return flips;
    }
}

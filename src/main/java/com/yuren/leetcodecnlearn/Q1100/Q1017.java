package com.yuren.leetcodecnlearn.Q1100;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-09-20 23:48
 */
public class Q1017 {
    public String baseNeg2(int n) {
        int max = 1;
        while (max > 0 && max < n) {
            max = (max << 2) + 1;
        }
        return Integer.toBinaryString(max ^ max - n);
    }
}

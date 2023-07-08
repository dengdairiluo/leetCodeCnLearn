package com.yuren.leetcodecnlearn.Q1700;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-07-08 22:33
 */
public class Q1749 {
    public int maxAbsoluteSum(int[] nums) {
        int prefix = 0, max = 0, min = 0;

        for (int x : nums) {
            prefix += x;
            if (prefix > max) {
                max = prefix;
            }
            if (prefix < min) {
                min = prefix;
            }
        }

        return max - min;
    }
}

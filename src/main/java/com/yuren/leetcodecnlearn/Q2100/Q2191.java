package com.yuren.leetcodecnlearn.Q2100;

import java.util.Arrays;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-01-22 23:17
 */
public class Q2191 {
    public int[] sortJumbled(int[] mapping, int[] nums) {
        final int length = nums.length;
        final long[] array = new long[length];
        for (int i = 0; i < length; i++) {
            array[i] = (((long) map(mapping, nums[i])) << 32) | i;
        }
        Arrays.sort(array);
        final int[] sorted = new int[length];
        for (int i = 0; i < length; i++) {
            sorted[i] = nums[(int) array[i]];
        }
        return sorted;
    }

    private int map(int[] mapping, int value) {
        if (value == 0) {
            return mapping[0];
        }
        int quantity = 0;
        int multiplier = 1;
        do {
            int digit = value % 10;
            quantity += mapping[digit] * multiplier;
            multiplier *= 10;
            value /= 10;
        } while (value != 0);
        return quantity;
    }
}

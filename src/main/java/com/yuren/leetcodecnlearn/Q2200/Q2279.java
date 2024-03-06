package com.yuren.leetcodecnlearn.Q2200;

import java.util.Arrays;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-03-06 23:40
 */
public class Q2279 {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        long sum = 0;
        int[] gap = new int[capacity.length];
        for (int i = 0; i < capacity.length; i++) {
            gap[i] = capacity[i] - rocks[i];
            sum += gap[i];
        }
        if (sum <= additionalRocks) {
            return capacity.length;
        }
        Arrays.sort(gap);
        int i = capacity.length - 1;
        for (; sum > additionalRocks; i--) {
            sum -= gap[i];//从大的开始减肯定更快
        }
        return i + 1;
    }
}

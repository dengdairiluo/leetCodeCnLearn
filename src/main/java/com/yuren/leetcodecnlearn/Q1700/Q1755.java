package com.yuren.leetcodecnlearn.Q1700;

import java.util.Arrays;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-07-09 23:28
 */
public class Q1755 {
    public int minAbsDifference(int[] nums, int goal) {
        int half = nums.length / 2;
        int[] sums1 = getSubSeqSums(nums, 0, half);
        int[] sums2 = getSubSeqSums(nums, half, nums.length);
        Arrays.sort(sums1);
        Arrays.sort(sums2);
        int minDiff = Integer.MAX_VALUE;
        Loop:
        for (int i1 = 0, i2 = sums2.length - 1; i1 < sums1.length; i1++) {
            for (; ; ) {
                int diff = sums1[i1] + sums2[i2] - goal;
                if (diff == 0) {
                    minDiff = 0;
                    break Loop;
                } else if (diff < 0) {
                    minDiff = Math.min(minDiff, -diff);
                    break;
                } else {
                    minDiff = Math.min(minDiff, diff);
                    if (--i2 < 0) {
                        break Loop;
                    }
                }
            }
        }
        return minDiff;
    }

    private int[] getSubSeqSums(int[] nums, int start, int end) {
        int[] sums = new int[1 << end - start];
        sums[0] = 0;
        int sumsLen = 1;
        for (int i = start; i < end; i++) {
            int num = nums[i];
            for (int j = 0; j < sumsLen; j++) {
                sums[j + sumsLen] = sums[j] + num;
            }
            sumsLen <<= 1;
        }
        return sums;
    }
}

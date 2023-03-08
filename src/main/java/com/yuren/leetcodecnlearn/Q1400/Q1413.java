package com.yuren.leetcodecnlearn.Q1400;

public class Q1413 {
    public int minStartValue(int[] nums) {
        int minStart = 1, sum = 1;
        for (int num : nums) {
            if ((sum += num) < 1) {
                minStart += 1 - sum;
                sum = 1;
            }
        }
        return minStart;
    }
}

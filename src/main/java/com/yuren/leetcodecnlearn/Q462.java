package com.yuren.leetcodecnlearn;

import java.util.Arrays;

public class Q462 {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int num : nums) {
            sum += Math.abs(nums[nums.length / 2] - num);
        }
        return sum;
    }
}

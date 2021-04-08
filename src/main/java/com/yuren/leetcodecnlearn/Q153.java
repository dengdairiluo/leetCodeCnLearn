package com.yuren.leetcodecnlearn;

import java.util.Arrays;

public class Q153 {
    public int findMin(int[] nums) {
        Arrays.sort(nums);
        return nums[0];
    }
}

package com.yuren.leetcodecnlearn.Q1500;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q1403 {
    public List<Integer> minSubsequence(int[] nums) {
        int n = nums.length;
        List<Integer> list = new ArrayList<>();
        int sum = 0;
        for (int num : nums) sum += num;

        Arrays.sort(nums);
        int count = 0;
        for (int i = n - 1; i >= 0; i--) {

            list.add(nums[i]);
            count += nums[i];
            if (count > (sum - count)) {

                break;
            }
        }
        return list;
    }
}

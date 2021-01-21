package com.yuren.leetcodecnlearn;

import java.util.Arrays;

public class Q1389 {

    public static int[] createTargetArray(int[] nums, int[] index) {
        int[] ans = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                index[j] += index[j] >= index[i] ? 1 : 0;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            ans[index[i]] = nums[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 2, 3, 4};
        int[] index = new int[]{0, 1, 2, 2, 1};
        System.out.println(Arrays.toString(createTargetArray(nums, index)));

    }
}

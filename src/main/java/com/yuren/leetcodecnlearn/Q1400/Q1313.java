package com.yuren.leetcodecnlearn.Q1400;

import java.util.Arrays;

public class Q1313 {

    private static int[] decompressRLElist(int[] nums) {
        int length = 0;
        for (int i = 0; i < nums.length; i += 2) {
            length += nums[i];
        }

        int[] ans = new int[length];
        int s = 0;
        for (int i = 0; i < nums.length; i += 2) {
            for (int j = 0; j < nums[i]; j++) {
                ans[s] = nums[i + 1];
                s++;
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4};
        System.out.println(Arrays.toString(decompressRLElist(nums)));
    }

}

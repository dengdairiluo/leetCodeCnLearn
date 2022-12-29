package com.yuren.leetcodecnlearn.Q1900;

public class Q1827 {

    private int minOperations1(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int ans = 0;

        int len = nums.length;

        for (int i = 1; i < len; i++) {
            if (nums[i - 1] >= nums[i]) {
                int tmp = nums[i - 1] + 1;
                ans += tmp - nums[i];
                nums[i] = tmp;
            }
        }
        return ans;
    }
}

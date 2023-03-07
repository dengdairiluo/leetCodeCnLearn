package com.yuren.leetcodecnlearn.Q500;

public class Q565 {
    public int arrayNesting(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            int count = 0, k = i;
            while (nums[k] != -1) {
                count++;
                int tmp = nums[k];
                nums[k] = -1;
                k = tmp;
            }
            result = Math.max(result, count);
        }
        return result;
    }
}

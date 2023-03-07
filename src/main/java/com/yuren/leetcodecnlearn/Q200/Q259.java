package com.yuren.leetcodecnlearn.Q200;

import java.util.Arrays;

public class Q259 {
    public int threeSumSmaller(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        // 先排序
        Arrays.sort(nums);
        int sum;
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                sum = nums[i] + nums[left] + nums[right];
                if (sum < target) {
                    // 说明right的位置满足条件，那么right和left之间的元素作为right时均满足条件
                    result += (right - left);
                    // left向右移动
                    left++;
                } else {
                    // 三个数字的和大于等于target，将right向左移动
                    right--;
                }
            }
        }
        return result;
    }
}

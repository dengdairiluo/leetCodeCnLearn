package com.yuren.leetcodecnlearn.Q1100;

import java.util.Arrays;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-10-24 23:55
 */
public class Q1099 {
    public int twoSumLessThanK(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        Arrays.sort(nums);

        int l = 0, r = nums.length - 1;
        int result = Integer.MIN_VALUE;

        while (l < r) {
            if (nums[l] + nums[r] >= k) {
                r--;
            } else {
                result = Math.max(result, nums[l] + nums[r]);
                l++;
            }
        }

        return result == Integer.MIN_VALUE ? -1 : result;
    }
}

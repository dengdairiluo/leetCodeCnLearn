package com.yuren.leetcodecnlearn.Q2500;

import java.util.Arrays;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-08-03 上午2:16
 */
public class Q2576 {
    public int maxNumOfMarkedIndices(int[] nums) {
        Arrays.sort(nums);
        int left = 0, right = nums.length / 2 + 1; // 开区间
        while (left + 1 < right) {
            int mid = (left + right) >>> 1;
            if (check(nums, mid)) left = mid;
            else right = mid;
        }
        return left * 2;
    }

    private boolean check(int[] nums, int k) {
        for (int i = 0; i < k; ++i)
            if (nums[i] * 2 > nums[nums.length - k + i])
                return false;
        return true;
    }
}

package com.yuren.leetcodecnlearn.Q2600;

import java.util.Arrays;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author 10204
 * @date 2024-08-25 21:32
 */
public class Q2616 {
    public int minimizeMax(int[] nums, int p) {
        Arrays.sort(nums);
        int n = nums.length, left = -1, right = nums[n - 1] - nums[0]; // 开区间
        while (left + 1 < right) { // 开区间
            int mid = (left + right) >>> 1, cnt = 0;
            for (int i = 0; i < n - 1; ++i)
                if (nums[i + 1] - nums[i] <= mid) { // 都选
                    ++cnt;
                    ++i;
                }
            if (cnt >= p) right = mid;
            else left = mid;
        }
        return right;
    }
}

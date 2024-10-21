package com.yuren.leetcodecnlearn.Q2700;

import java.util.Arrays;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author 10204
 * @date 2024-10-21 23:31
 */
public class Q2733 {
    public int findNonMinOrMax(int[] nums) {
        if (nums.length < 3) return -1;
        // 只对前三个数排序
        Arrays.sort(nums, 0, 3);
        return nums[1];
    }
}

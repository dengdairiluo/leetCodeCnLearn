package com.yuren.leetcodecnlearn.Q2700;

import java.util.Arrays;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author 10204
 * @date 2024-11-12 23:46
 */
public class Q2779 {
    public int maximumBeauty(int[] nums, int k) {
        Arrays.sort(nums);
        int ans = 0;
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            while (nums[right] - nums[left] > k * 2) {
                left++;
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }
}

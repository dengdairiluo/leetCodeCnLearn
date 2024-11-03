package com.yuren.leetcodecnlearn.Q2700;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author 10204
 * @date 2024-11-03 23:00
 */
public class Q2760 {
    public int longestAlternatingSubarray(int[] nums, int threshold) {
        int n = nums.length;
        int ans = 0, i = 0;
        while (i < n) {
            if (nums[i] > threshold || nums[i] % 2 != 0) {
                i++; // 直接跳过
                continue;
            }
            int start = i; // 记录这一组的开始位置
            do {
                i++;
            } while (i < n && nums[i] <= threshold && nums[i] % 2 != nums[i - 1] % 2);
            // 从 start 到 i-1 是满足题目要求的（并且无法再延长的）子数组
            ans = Math.max(ans, i - start);
        }
        return ans;
    }
}

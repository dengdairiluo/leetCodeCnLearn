package com.yuren.leetcodecnlearn.Q1900;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-09-11 23:49
 */
public class Q1918 {
    public int kthSmallestSubarraySum(int[] nums, int k) {
        // 最小可能的子数组和
        int left = 0;
        // 最大可能的子数组和
        int right = 0;
        for (int num : nums) {
            right += num;
        }

        int result = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (!match(nums, mid, k)) {
                left = mid + 1;
            } else {
                // 找左边界
                // 如果找到一个match的，但它不一定是数组和sum，所以继续往左边界找。
                result = mid;
                right = mid - 1;
            }
        }

        return result;
    }

    // 计算不超过 target 的子数组和的个数
    private boolean match(int[] nums, int target, int k) {
        int count = 0;
        int sum = 0;
        int left = 0;

        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            while (sum > target) {
                sum -= nums[left];
                left++;
            }
            count += right - left + 1;
        }

        return count >= k;
    }
}

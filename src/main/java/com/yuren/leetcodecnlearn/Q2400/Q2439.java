package com.yuren.leetcodecnlearn.Q2400;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-05-26 下午10:51
 */
public class Q2439 {
    public int minimizeArrayValue(int[] nums) {
        int left = -1;
        int right = 0;
        for (int x : nums) {
            right = Math.max(right, x);
        }
        // 开区间二分，原理见 https://www.bilibili.com/video/BV1AP41137w7/
        while (left + 1 < right) {
            int mid = (left + right) / 2;
            if (check(nums, mid)) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return right;
    }

    private boolean check(int[] nums, int limit) {
        long extra = 0;
        for (int i = nums.length - 1; i > 0; i--) {
            extra = Math.max(nums[i] + extra - limit, 0);
        }
        return nums[0] + extra <= limit;
    }
}

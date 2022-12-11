package com.yuren.leetcodecnlearn.Q500;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-01-31 21:34
 */
public class Q487 {
    public int findMaxConsecutiveOnes(int[] nums) {
        int n = nums.length;
        // 窗口的两个边界，以及 cnt 用来记录出现 0 的个数
        int left = 0, right = 0, cnt = 0;
        // 返回值
        int ans = 0;
        while (right < n) {
            // 只要右边界不越界，而且0的个数小于等于 1 个，那么就扩充右边界
            while (right < n && cnt <= 1) {
                if (nums[right] == 0) {
                    cnt++;
                }
                right++;
                // 及时更新返回值
                if (cnt <= 1) {
                    ans = Math.max(right - left, ans);
                }
            }
            // 向右缩小左边界，直到 0 的个数小于等于 1
            while (left <= right && cnt > 1) {
                if (nums[left] == 0) {
                    cnt--;
                }
                left++;
            }
        }
        return ans;
    }
}

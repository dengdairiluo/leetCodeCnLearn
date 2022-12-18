package com.yuren.leetcodecnlearn.Q1100;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-09-14 23:48
 */
public class Q1004 {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int res = 0;
        int left = 0;
        int right = 0;
        int zeros = 0;
        while (right < n) {
            if (nums[right] == 0) {
                zeros++;
            }
            while (zeros > k) {
                if (nums[left++] == 0) {
                    zeros--;
                }
            }
            res = Math.max(res, right - left + 1);
            right++;
        }
        return res;
    }
}

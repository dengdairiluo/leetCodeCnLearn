package com.yuren.leetcodecnlearn.Q1700;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-06-21 23:05
 */
public class Q1708 {
    public int[] largestSubarray(int[] nums, int k) {
        return largestSubarrayCal(nums, k);
    }

    //其实就是找数组倒数第k个元素前面最大值，然后复制k个元素下来就好了
    //题目提示，所有元素都不相同，不用考虑相同然后复杂比较
    //就是一个找最大值，一个复制元素操作而已
    public int[] largestSubarrayCal(int[] nums, int k) {
        if (k > nums.length) {
            return null;
        }
        if (k == nums.length) {
            return nums;
        }
        int n = nums.length - k, i;
        int maxindex = 0, max = nums[0];
        for (i = 1; i <= n; i++) {
            if (nums[i] > max) {
                max = nums[i];
                maxindex = i;
            }
        }
        int[] bak = new int[k];
        for (int j = maxindex; j - maxindex < k; j++) {
            bak[j - maxindex] = nums[j];
        }
        return bak;
    }
}

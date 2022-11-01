package com.yuren.leetcodecnlearn;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-11-01 23:38
 */
public class Q1121 {
    public boolean canDivideIntoSubsequences(int[] nums, int k) {
        int max = 1;    // 最长重复元素个数
        int temp = 1;   // 当前元素重复个数
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                temp++;
            } else {
                max = Math.max(max, temp);
                temp = 1;
            }
        }
        max = Math.max(max, temp);
        return max * k <= nums.length;
    }
}

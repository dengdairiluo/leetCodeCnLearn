package com.yuren.leetcodecnlearn.Q2200;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-02-15 22:57
 */
public class Q2239 {
    public int findClosestNumber(int[] nums) {
        int closest = nums[0];
        int minDifference = Math.abs(nums[0]);
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            int num = nums[i];
            int difference = Math.abs(num);
            if (difference < minDifference || (difference == minDifference && num > closest)) {
                minDifference = difference;
                closest = num;
            }
        }
        return closest;
    }
}

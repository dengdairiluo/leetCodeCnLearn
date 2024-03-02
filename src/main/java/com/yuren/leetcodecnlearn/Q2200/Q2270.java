package com.yuren.leetcodecnlearn.Q2200;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-03-02 22:49
 */
public class Q2270 {
    public int waysToSplitArray(int[] nums) {
        int ways = 0;
        long leftSum = 0, rightSum = 0;
        for (int num : nums) {
            rightSum += num;
        }
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            leftSum += nums[i];
            rightSum -= nums[i];
            if (leftSum >= rightSum) {
                ways++;
            }
        }
        return ways;
    }
}

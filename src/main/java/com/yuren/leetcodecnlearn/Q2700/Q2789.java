package com.yuren.leetcodecnlearn.Q2700;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author 10204
 * @date 2024-11-17 23:22
 */
public class Q2789 {
    public long maxArrayValue(int[] nums) {
        int n = nums.length;
        long sum = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            sum = nums[i] <= sum ? sum + nums[i] : nums[i];
        }
        return sum;
    }
}

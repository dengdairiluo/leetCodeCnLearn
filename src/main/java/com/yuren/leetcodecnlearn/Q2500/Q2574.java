package com.yuren.leetcodecnlearn.Q2500;

import java.util.Arrays;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-08-03 上午2:10
 */
public class Q2574 {
    public int[] leftRightDifference(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        int[] ans = new int[nums.length];
        int temp = 0;//左边和
        for (int i = 0; i < nums.length; i++) {
            ans[i] = Math.abs(sum - temp - nums[i] - temp);
            temp += nums[i];
        }
        return ans;

    }
}

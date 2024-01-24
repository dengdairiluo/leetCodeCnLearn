package com.yuren.leetcodecnlearn.Q2100;

import java.util.Arrays;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-01-24 23:33
 */
public class Q2195 {
    public long minimalKSum(int[] nums, int k) {
        long sum = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= k) {
                if (i == 0 || nums[i] != nums[i - 1]) {
                    sum += nums[i];
                    k++;
                }
            } else break;
        }
        return (1L + k) * k / 2 - sum;
    }
}

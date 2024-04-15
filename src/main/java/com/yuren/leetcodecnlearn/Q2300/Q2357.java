package com.yuren.leetcodecnlearn.Q2300;

import java.util.Arrays;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-04-15 下午11:55
 */
public class Q2357 {
    public int minimumOperations(int[] nums) {
        int ans = 0;
        Arrays.sort(nums);
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if (nums[i] > 0) {
                subtract(nums, nums[i], i);
                ans++;
            }
        }
        return ans;
    }

    public void subtract(int[] nums, int x, int startIndex) {
        int length = nums.length;
        for (int i = startIndex; i < length; i++) {
            nums[i] -= x;
        }
    }
}

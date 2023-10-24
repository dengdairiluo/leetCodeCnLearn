package com.yuren.leetcodecnlearn.Q2000;

import java.util.Arrays;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-10-24 23:13
 */
public class Q2009 {
    public int minOperations(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;

        int m = 1;
        for (int i = 1; i < n; ++i) {
            if (nums[i] != nums[i - 1])
                nums[m++] = nums[i];
        }

        int l = 0, r = 0;

        while (r < m) {
            if (nums[r] - nums[l] > n - 1) l++;
            r++;
        }
        return n - (r - l);
    }
}

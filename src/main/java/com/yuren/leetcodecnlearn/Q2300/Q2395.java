package com.yuren.leetcodecnlearn.Q2300;

import java.util.HashSet;
import java.util.Set;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-05-03 下午11:21
 */
public class Q2395 {
    public long countSubarrays(int[] nums) {
        long subarrays = 0;
        int count = 0;
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if (i > 0 && nums[i] > nums[i - 1]) {
                count++;
            } else {
                count = 1;
            }
            subarrays += count;
        }
        return subarrays;
    }

    public boolean findSubarrays(int[] nums) {
        Set<Integer> vis = new HashSet<>();
        for (int i = 1; i < nums.length; ++i) {
            if (!vis.add(nums[i - 1] + nums[i])) {
                return true;
            }
        }
        return false;
    }
}

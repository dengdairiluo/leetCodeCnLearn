package com.yuren.leetcodecnlearn.Q1500;

import java.util.HashSet;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-04-22 23:48
 */
public class Q1546 {
    public int maxNonOverlapping(int[] nums, int target) {
        int[] sum = new int[nums.length + 1];
        sum[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }
        HashSet<Integer> set = new HashSet<>();
        int count = 0;
        for (int i : sum) {
            int diff = i - target;
            if (set.contains(diff)) {
                count++;
                set.clear();
                set.add(i);
            } else {
                set.add(i);
            }
        }
        return count;
    }
}

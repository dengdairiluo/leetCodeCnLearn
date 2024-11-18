package com.yuren.leetcodecnlearn.Q2700;

import java.util.Arrays;
import java.util.List;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author 10204
 * @date 2024-11-18 23:44
 */
public class Q2790 {
    public int maxIncreasingGroups(List<Integer> usageLimits) {
        final int n = usageLimits.size();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = usageLimits.get(i);
        }

        Arrays.sort(nums);

        int length = 1, right = 0;
        long preSum = 0l;

        while (right < n) {
            preSum += nums[right] - length;
            if (preSum < 0) preSum += length;
            else length++;
            right++;
        }

        return length - 1;
    }
}

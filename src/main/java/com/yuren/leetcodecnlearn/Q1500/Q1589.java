package com.yuren.leetcodecnlearn.Q1500;

import java.util.Arrays;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-05-09 23:46
 */
public class Q1589 {
    public int maxSumRangeQuery(int[] nums, int[][] requests) {
        final int MODULO = 1000000007;
        int length = nums.length;
        int[] counts = new int[length];
        for (int[] request : requests) {
            int start = request[0], end = request[1];
            counts[start]++;
            if (end + 1 < length) {
                counts[end + 1]--;
            }
        }
        for (int i = 1; i < length; i++) {
            counts[i] += counts[i - 1];
        }
        Arrays.sort(counts);
        Arrays.sort(nums);
        long sum = 0;
        for (int i = length - 1; i >= 0 && counts[i] > 0; i--) {
            sum += (long) nums[i] * counts[i];
        }
        return (int) (sum % MODULO);
    }
}

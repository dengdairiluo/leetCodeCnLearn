package com.yuren.leetcodecnlearn.Q1800;

import java.util.Arrays;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-08-26 21:24
 */
public class Q1885 {
    public long countPairs(int[] nums1, int[] nums2) {
        int length = nums1.length;
        for (int i = 0; i < length; i++) {
            nums1[i] -= nums2[i];
        }
        Arrays.sort(nums1);
        long sum = 0;

        for (int i = 0; i < length; i++) {
            int t = nums1[i];
            if (t <= 0) {
                continue;
            }
            int index = find(nums1, -t);
            if (index != -1) {
                sum = sum + (i - index);
            }
        }
        return sum;
    }

    private int find(int[] nums, int t) {
        int st = 0;
        int end = nums.length - 1;
        if (nums[end] <= t) {
            return -1;
        }
        while (st < end) {
            int m = st + ((end - st) >> 1);
            if (nums[m] <= t) {
                st = m + 1;
            } else {
                end = m;
            }
        }
        return st;
    }
}

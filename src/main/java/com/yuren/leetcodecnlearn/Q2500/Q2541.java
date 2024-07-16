package com.yuren.leetcodecnlearn.Q2500;

import java.util.Arrays;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-07-16 下午11:52
 */
public class Q2541 {
    public long minOperations(int[] nums1, int[] nums2, int k) {
        if (k == 0) {
            return Arrays.equals(nums1, nums2) ? 0 : -1;
        }
        long ops1 = 0, ops2 = 0;
        int n = nums1.length;
        for (int i = 0; i < n; i++) {
            int diff = nums2[i] - nums1[i];
            if (diff % k != 0) {
                return -1;
            }
            if (diff > 0) {
                ops1 += diff / k;
            } else if (diff < 0) {
                ops2 += -diff / k;
            }
        }
        if (ops1 == ops2) {
            return ops1;
        }
        return -1;
    }

}

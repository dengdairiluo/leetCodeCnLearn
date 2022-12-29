package com.yuren.leetcodecnlearn.Q1900;

import java.util.Arrays;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2021-07-10 23:26
 */
public class Q1874 {
    public int minProductSum(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int len = nums1.length;
        int out = 0;
        for (int i = 0; i < len; i++) {
            out = out + nums1[i] * nums2[len - i - 1];
        }
        return out;
    }
}

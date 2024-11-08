package com.yuren.leetcodecnlearn.Q2700;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author 10204
 * @date 2024-11-08 23:56
 */
public class Q2771 {
    public int maxNonDecreasingLength(int[] nums1, int[] nums2) {
        int n = nums1.length;

        // dp1[i] 表示以 nums1[i] 结尾的最长非递减子数组长度
        // dp2[i] 表示以 nums2[i] 结尾的最长非递减子数组长度
        int[] dp1 = new int[n], dp2 = new int[n];
        Arrays.fill(dp1, 1);
        Arrays.fill(dp2, 1);

        for (int i = 1; i < n; i++) {
            if (nums1[i] >= nums1[i - 1]) {
                dp1[i] = Math.max(dp1[i], dp1[i - 1] + 1);
            }

            if (nums1[i] >= nums2[i - 1]) {
                dp1[i] = Math.max(dp1[i], dp2[i - 1] + 1);
            }

            if (nums2[i] >= nums2[i - 1]) {
                dp2[i] = Math.max(dp2[i], dp2[i - 1] + 1);
            }

            if (nums2[i] >= nums1[i - 1]) {
                dp2[i] = Math.max(dp2[i], dp1[i - 1] + 1);
            }
        }

        int max1 = IntStream.of(dp1).max().getAsInt();
        int max2 = IntStream.of(dp2).max().getAsInt();
        return Math.max(max1, max2);
    }
}

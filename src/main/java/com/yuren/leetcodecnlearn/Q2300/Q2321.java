package com.yuren.leetcodecnlearn.Q2300;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-03-27 23:50
 */
public class Q2321 {
    public static int solve(int[] a, int[] b) {
        int maxsum = 0, s = 0;
        int n = a.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += a[i];
        }
        for (int i = 0; i < n; i++) {
            s += b[i] - a[i];
            if (s < 0) s = 0;
            if (s > maxsum) maxsum = s;
        }
        return sum + maxsum;
    }

    public int maximumsSplicedArray(int[] nums1, int[] nums2) {
        return Math.max(solve(nums1, nums2), solve(nums2, nums1));
    }
}

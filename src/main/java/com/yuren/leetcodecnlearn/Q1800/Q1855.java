package com.yuren.leetcodecnlearn.Q1800;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-08-16 23:39
 */
public class Q1855 {
    public int maxDistance(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int l = 0, r = 0;
        while (l < m && r < n) {
            if (nums1[l] > nums2[r]) {
                l++;
            }
            r++;
        }
        return Math.max(r - l - 1, 0);
    }
}

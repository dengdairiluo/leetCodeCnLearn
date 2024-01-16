package com.yuren.leetcodecnlearn.Q2100;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-01-16 23:11
 */
public class Q2179 {
    public long goodTriplets(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int[] p = new int[n];
        for (int i = 0; i < n; i++) p[nums1[i]] = i;
        long res = 0;
        int[] tree = new int[n + 1];
        for (int i = 1; i < n - 1; i++) {
            for (int j = p[nums2[i - 1]] + 1; j <= n; j += (j & -j)) {
                tree[j]++;
            }
            int y = p[nums2[i]];
            int less = 0;
            for (int j = y; j > 0; j -= (j & -j)) {
                less += tree[j];
            }
            res += (long) less * (n - 1 - y - (i - less));
        }
        return res;
    }
}

package com.yuren.leetcodecnlearn.Q2000;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-11-08 23:42
 */
public class Q2040 {
    /* 2040.两个有序数组的第 K 小乘积: https://leetcode.cn/problems/kth-smallest-product-of-two-sorted-arrays/
     * 相似题汇总:
     *  719.找出第 k 小的距离对: https://leetcode.cn/problems/find-k-th-smallest-pair-distance/
     *
     * 2022-05 微软一面面试题类似, 不过它给的是两个正整数有序数组, 比这个简单点
     * 难点是正负混合
     * 但很容易求出积为正数量和积为负的数量
     * neg1*pos2 + pos1*neg2 是所有负数的数量
     *
     * [min, max] 二分
     * 满足 count(x) <= k 中最小的一个 x
     *
     * 还是分类讨论比较简单
     * 1,2 | -4,-3,-2,-1
     *
     * -4,-3,-2,-1
     * -8,-6,-4,-1
     *
     * neg1 & neg2
     *  左到右，上到下；递减。/ 右边就是更小的
     * pos1 & pos2
     *  左到右，上到下；递增。/ 左边就是更小的
     * pos1 & neg2
     *  左到右递增，上到下递减。\ 左边就是更小的
     * neg1 & pos2
     *  左到右递减，上到下递增。\ 右边就是更小的
     * 注意
     *  1. 正/负如何向下取整
     *  2. 10^5 相乘，超出了 int 的范围
     *  3. 最小值和最大值在 4 个数中选两个
     */
    public long kthSmallestProduct(int[] nums1, int[] nums2, long k) {
        int neg1 = 0;
        for (int n : nums1)
            if (n < 0) neg1++;

        int neg2 = 0;
        for (int n : nums2)
            if (n < 0) neg2++;

        int n1 = nums1.length - 1, n2 = nums2.length - 1;
        long l = Math.min((long) nums1[0] * nums2[0], (long) nums1[n1] * nums2[n2]);
        l = Math.min(l, (long) nums1[0] * nums2[n2]);
        l = Math.min(l, (long) nums1[n1] * nums2[0]);
        long r = Math.max((long) nums1[n1] * nums2[n2], (long) nums1[0] * nums2[0]);
        r = Math.max(r, (long) nums1[0] * nums2[n2]);
        r = Math.max(r, (long) nums1[n1] * nums2[0]);

        while (l < r) {
            // 向下取整
            // int mid = l+r < 0 ? (l+r-1)/2 : (l+r)/2;
            // 正负均向下取整
            long mid = (l + r) >> 1;
            if (count(nums1, nums2, neg1, neg2, mid) >= k) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    /**
     * @return 逻辑二维矩阵中, <= x 的数的数量
     */
    private long count(int[] nums1, int[] nums2, int neg1, int neg2, long x) {
        int pos1 = nums1.length - neg1;
        int pos2 = nums2.length - neg2;

        long cnt = 0;
        if (x < 0) {
            // 越往下越大，越往右越小
            for (int i = 0, j = neg2; i < neg1; i++) {
                while (j < nums2.length && (long) nums1[i] * nums2[j] > x)
                    j++;
                cnt += nums2.length - j;
            }

            // 越往上越大，越往左越小
            for (int i = nums1.length - 1, j = neg2 - 1; i >= neg1; i--) {
                while (j >= 0 && (long) nums1[i] * nums2[j] > x)
                    j--;
                cnt += j + 1;
            }
            return cnt;
        }

        // 越往上越大, 越往右越小 /
        for (int i = neg1 - 1, j = 0; i >= 0; i--) {
            while (j < neg2 && (long) nums1[i] * nums2[j] > x)
                j++;
            cnt += neg2 - j;
        }
        // 越往下越大, 越往左越小 /
        for (int i = neg1, j = nums2.length - 1; i < nums1.length; i++) {
            while (j >= neg2 && (long) nums1[i] * nums2[j] > x)
                j--;
            cnt += j - neg2 + 1;
        }
        cnt += (long) neg1 * pos2 + (long) pos1 * neg2;
        return cnt;
    }
}

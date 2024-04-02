package com.yuren.leetcodecnlearn.Q2300;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-04-02 23:27
 */
public class Q2333 {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int max = 0, knum = k1 + k2;
        long diffSum = 0;
        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = Math.abs(nums1[i] - nums2[i]);
            if (nums1[i] > 0) {
                diffSum += nums1[i];
                max = Math.max(max, nums1[i]);
            }
        }
        if (diffSum <= knum) {
            return 0;
        }
        int[] diff = new int[max + 1];
        //桶排序梳理差值
        for (int j : nums1) {
            diff[j]++;
        }
        for (int i = max; i > 0; i--) {
            //若最大值的数量小于操作数
            if (diff[i] <= knum) {
                //所有最大值减一，计入max-1
                diff[i - 1] += diff[i];
                //对这个数量的最大值减一操作
                knum -= diff[i];
                max--;
            //若大于操作数
            } else {
                //操作knum个最大值
                diff[i] -= knum;
                //计入max-1
                diff[i - 1] += knum;
                //清空操作数目
                knum = 0;
            }
            if (knum == 0) {
                break;
            }
        }
        long ans = 0;
        for (int i = 1; i <= max; i++) {
            ans += (long) diff[i] * (long) i * i;
        }
        return ans;
    }
}

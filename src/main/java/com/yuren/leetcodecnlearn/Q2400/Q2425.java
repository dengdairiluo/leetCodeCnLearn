package com.yuren.leetcodecnlearn.Q2400;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-05-20 下午11:55
 */
public class Q2425 {
    public int xorAllNums(int[] nums1, int[] nums2) {
        int a = 0, b = 0, m = nums1.length, n = nums2.length;
        //计算出`nums1`, `nums2`数组的异或和
        for (int v : nums2) b ^= v;
        for (int v : nums1) a ^= v;
        //若`len(nums2) % 2 == 0`则`nums1`数组的`n`个异或和为0，否则为1，`nums2`同理
        if (n % 2 == 0) a = 0;
        if (m % 2 == 0) b = 0;
        //答案
        return a ^ b;
    }
}

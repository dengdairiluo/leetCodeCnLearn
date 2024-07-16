package com.yuren.leetcodecnlearn.Q2500;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-07-16 下午11:49
 */
public class Q2540 {
    public int getCommon(int[] nums1, int[] nums2) {
        for (int i = 0, j = 0; i < nums1.length && j < nums2.length; ) {
            if (nums1[i] == nums2[j]) {
                // 找到公共最小值
                return nums1[i];
            } else {
                // 值不相等，移动较小值数组的游标
                if (nums1[i] < nums2[j]) {
                    i++;
                } else {
                    j++;
                }
            }
        }

        // 没有公共整数
        return -1;
    }
}

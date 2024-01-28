package com.yuren.leetcodecnlearn.Q2200;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-01-28 23:11
 */
public class Q2202 {
    public int maximumTop(int[] nums, int k) {
        if (nums.length == 1) {
            if (k % 2 != 0) {
                return -1;
            }
        }
        int res = 0;
        if (nums.length < k) {
            //栈内最大元素
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] > res) {
                    res = nums[i];
                }
            }
            return res;
        } else {
            if (nums.length == k) {
                if (k % 2 != 0) {
                    for (int i = 0; i < nums.length - 1; i++) {
                        if (nums[i] > res) {
                            res = nums[i];
                        }
                    }
                    return res;
                }
            }
            //删除k个和k-1个中的最大进行对比
            int kMax = nums[k];
            for (int i = 0; i < k - 1; i++) {
                if (nums[i] > res) {
                    res = nums[i];
                }
            }
            return Math.max(kMax, res);
        }
    }
}

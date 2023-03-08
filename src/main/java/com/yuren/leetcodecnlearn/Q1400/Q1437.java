package com.yuren.leetcodecnlearn.Q1400;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-03-08 23:52
 */
public class Q1437 {
    public boolean kLengthApart(int[] nums, int k) {
        int n = nums.length;
        int prev = -1;
        for (int i = 0; i < n; ++i) {
            if (nums[i] == 1) {
                if (prev != -1 && i - prev - 1 < k) {
                    return false;
                }
                prev = i;
            }
        }
        return true;
    }
}

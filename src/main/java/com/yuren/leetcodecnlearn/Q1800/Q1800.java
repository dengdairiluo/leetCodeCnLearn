package com.yuren.leetcodecnlearn.Q1800;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-07-26 23:37
 */
public class Q1800 {
    public int maxAscendingSum(int[] nums) {
        int res = 0;
        int l = 0;
        while (l < nums.length) {
            int cursum = nums[l++];
            while (l < nums.length && nums[l] > nums[l - 1]) {
                cursum += nums[l++];
            }
            res = Math.max(res, cursum);
        }
        return res;
    }
}

package com.yuren.leetcodecnlearn.Q2000;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-12-03 23:13
 */
public class Q2091 {
    public int minimumDeletions(int[] nums) {
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        int maxi = 0, mini = 0;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            int num = nums[i];
            if (num > max) {
                max = num;
                maxi = i;
            }
            if (num < min) {
                min = num;
                mini = i;
            }
        }
        int l = Math.min(maxi, mini);
        int r = Math.max(maxi, mini);
        return Math.min(Math.min(r + 1, len - l), l + 1 + len - r);
    }
}

package com.yuren.leetcodecnlearn.Q2600;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author 10204
 * @date 2024-09-25 00:49
 */
public class Q2680 {
    public long maximumOr(int[] nums, int k) {
        int n = nums.length;
        int[] suf = new int[n + 1];
        for (int i = n - 1; i > 0; i--)
            suf[i] = suf[i + 1] | nums[i];
        long ans = 0;
        for (int i = 0, pre = 0; i < n; i++) {
            ans = Math.max(ans, pre | ((long) nums[i] << k) | suf[i + 1]);
            pre |= nums[i];
        }
        return ans;
    }
}

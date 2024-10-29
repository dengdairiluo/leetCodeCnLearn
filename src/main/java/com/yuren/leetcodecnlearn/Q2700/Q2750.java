package com.yuren.leetcodecnlearn.Q2700;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author 10204
 * @date 2024-10-29 23:55
 */
public class Q2750 {
    public int numberOfGoodSubarraySplits(int[] nums) {
        final long MOD = (long) 1e9 + 7;
        long ans = 1;
        int pre = -1, n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) continue;
            if (pre >= 0) ans = ans * (i - pre) % MOD;
            pre = i;
        }
        return pre < 0 ? 0 : (int) ans;
    }

}

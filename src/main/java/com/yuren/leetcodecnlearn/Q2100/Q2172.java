package com.yuren.leetcodecnlearn.Q2100;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-01-14 22:56
 */
public class Q2172 {
    public int maximumANDSum(int[] nums, int slots) {
        Integer[] memo = new Integer[1 << (2 * slots)];
        return helper(nums, slots, 0, 0, memo);
    }

    private int helper(int[] nums, int slots, int index, int state, Integer[] memo) {
        if (index == nums.length) {
            return 0;
        }
        if (memo[state] != null) {
            return memo[state];
        }
        int res = 0;
        for (int i = 0; i < slots; i++) {
            if ((state & (1 << (2 * i + 1))) != 0) {
                continue;
            }
            int next = state;
            if ((state & (1 << (2 * i))) == 0) {
                next |= 1 << (2 * i);
            } else {
                next |= 1 << (2 * i + 1);
            }
            res = Math.max(res, (nums[index] & (i + 1)) + helper(nums, slots, index + 1, next, memo));
        }
        memo[state] = res;
        return res;
    }
}

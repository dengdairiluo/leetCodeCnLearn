package com.yuren.leetcodecnlearn.Q2700;

import java.util.Arrays;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author 10204
 * @date 2024-11-08 23:56
 */
public class Q2770 {
    // jump[i] 表示从下标 0 开始跳到 nums[i] 所需的最大跳跃次数
    int[] jump;

    public int maximumJumps(int[] nums, int target) {
        this.jump = new int[nums.length];
        Arrays.fill(jump, Integer.MIN_VALUE);
        jump[0] = 0;
        int maximumJumps = dfs(nums, nums.length - 1, target);
        return maximumJumps >= 0 ? maximumJumps : -1;
    }

    // 返回从下标 i 跳到下标 0 所需最大的跳跃次数
    private int dfs(int[] nums, int i, int target) {
        if (jump[i] != Integer.MIN_VALUE) {
            return jump[i];
        }

        int max = Integer.MIN_VALUE;
        for (int j = i - 1; j >= 0; j--) {
            int val = nums[j] - nums[i];
            if (-target <= val && val <= target) {
                int jump = dfs(nums, j, target) + 1;
                max = Math.max(max, jump);
            }
        }

        return jump[i] = max;
    }
}

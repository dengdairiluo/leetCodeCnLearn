package com.yuren.leetcodecnlearn.Q2700;

import java.util.Arrays;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author 10204
 * @date 2024-10-25 01:13
 */
public class Q2741 {
    public int specialPerm(int[] nums) {
        int n = nums.length;
        int u = (1 << n) - 1;
        long[][] memo = new long[u][n];
        for (long[] row : memo) {
            // -1 表示没有计算过
            Arrays.fill(row, -1);
        }
        long ans = 0;
        for (int i = 0; i < n; i++) {
            ans += dfs(u ^ (1 << i), i, nums, memo);
        }
        return (int) (ans % 1_000_000_007);
    }

    private long dfs(int s, int i, int[] nums, long[][] memo) {
        if (s == 0) {
            // 找到一个特别排列
            return 1;
        }
        // 之前计算过
        if (memo[s][i] != -1) {
            return memo[s][i];
        }
        long res = 0;
        for (int j = 0; j < nums.length; j++) {
            if ((s >> j & 1) > 0 && (nums[i] % nums[j] == 0 || nums[j] % nums[i] == 0)) {
                res += dfs(s ^ (1 << j), j, nums, memo);
            }
        }
        // 记忆化
        return memo[s][i] = res;
    }
}

package com.yuren.leetcodecnlearn.Q1000;

import java.util.Arrays;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-09-13 23:43
 */
public class Q1000 {
    /**
     * 动态规划（DFS记忆化搜索）
     *
     * @param stones
     * @param K
     * @return
     */
    public static int mergeStones(int[] stones, int K) {
        int n = stones.length;
        if (n == 1) {
            return 0;
        }
        if (!canMerge(K, n)) {
            return -1;
        }
        int[] preSum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            preSum[i + 1] = preSum[i] + stones[i];
        }
        int[][] memo = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(memo[i], -2);
        }
        return merge(K, 0, n - 1, 1, preSum, memo);
    }

    // [l ... r]合并为part份的最小代价，如果无法完成，返回-1
    // preSum[i]：[0 ... i-1]的前缀累加和
    // memo[l][r]：记忆化数组
    private static int merge(int K, int l, int r, int part, int[] preSum, int[][] memo) {
        if (memo[l][r] >= -1) {
            return memo[l][r];
        }

        long cost;
        // 只有1个数了，part只能为1才可以完成
        if (l == r) {
            cost = part == 1 ? 0 : -1;
        // l < r && part == 1，不止1个数，最终要合并成1份
        } else if (part == 1) {
            // 先合并成K份，最后再将K份合并为1份
            // 前面步骤的代价：
            int preStepCost = merge(K, l, r, K, preSum, memo);
            if (preStepCost == -1) {
                return -1;
            }
            // 最后1步的代价：
            int lastStepCost = preSum[r + 1] - preSum[l];
            // 最终代价：
            cost = preStepCost + lastStepCost;
        } else { // l < r && part > 1，不止1个数，要合并成不止1份
            cost = Long.MAX_VALUE;
            // 枚举每一个可能的第1份，[l ... end]做第一份，剩下的[end+1 ... r]再合并成part-1份：
            for (int end = l; end < r; end += K - 1) {
                // 合并第1份的代价：
                int firstPartCost = merge(K, l, end, 1, preSum, memo);
                if (firstPartCost == -1) {
                    continue;
                }
                // 合并剩下的part-1份的代价：
                int nextPartCost = merge(K, end + 1, r, part - 1, preSum, memo);
                if (nextPartCost == -1) {
                    continue;
                }
                // 最终代价：
                cost = Math.min(cost, firstPartCost + nextPartCost);
            }
            cost = cost == Long.MAX_VALUE ? -1 : (int) cost;
        }

        memo[l][r] = (int) cost;
        return memo[l][r];
    }

    /**
     * n个数，k个一组合并，最终能否合并成1份?
     *
     * @param k
     * @param n
     * @return
     */
    private static boolean canMerge(int k, int n) {
        return n == k || (n > k && (((n - k) % (k - 1)) == 0));
    }

}

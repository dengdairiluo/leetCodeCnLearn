package com.yuren.leetcodecnlearn.Q1200;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-11-10 23:39
 */
public class Q1140 {
    // 一开始把这道题和区间 dp 联系在一起，是不对的

    public int stoneGameII(int[] piles) {
        int len = piles.length;
        int[][] memo = new int[len][len + 1];

        // [i, j] 的前缀和 preSum[j + 1] - preSum[i]
        int[] preSum = new int[len + 1];
        for (int i = 0; i < len; i++) {
            preSum[i + 1] = preSum[i] + piles[i];
        }
        int res = dfs(piles, 0, 1, preSum, memo);
        // 由于得到的是相对分数，需要转换成为绝对分数
        return (preSum[len] + res) / 2;
    }

    /**
     * @param piles
     * @param begin 定义石子堆的起始下标，即在 [start, len - 1] 这个区间里取石子
     * @param M     当前先手可以拿 [1, 2 * M] 堆石子（如果石子数够的话）
     * @param memo
     * @return 当前玩家在区间 [start, len - 1] 这个区间里取石子，得到的「相对分数」
     */
    private int dfs(int[] piles, int begin, int M, int[] preSum, int[][] memo) {
        int len = piles.length;
        if (begin >= len) {
            return 0;
        }

        if (memo[begin][M] != 0) {
            return memo[begin][M];
        }
        // 当前区间 [begin, len - 1] 的元素个数 len - begin <= 2M 的时候，
        // 全部拿走是利益最大的，这是因为 1 <= piles[i] <= 10 ^ 4
        if (len - begin <= 2 * M) {
            memo[begin][M] = preSum[len] - preSum[begin];
            return preSum[len] - preSum[begin];
        }

        // 走到这里，可以取的石子堆数 1 <= X <= 2M
        // 区间 [begin, j] 的长度 j - begin + 1 >= 2 * M
        int minLen = Math.min(2 * M, len - begin);
        // 这个初始化很重要，因为有可能是负分，所以不能初始化为 0
        int res = Integer.MIN_VALUE;
        for (int X = 1; X <= minLen; X++) {
            // 区间 [begin, begin + X - 1] 的前缀和 = preSum[begin + X] - preSum[begin - 1]
            int chooseLeft = preSum[begin + X] - preSum[begin];
            res = Math.max(res, chooseLeft - dfs(piles, begin + X, Math.max(M, X), preSum, memo));
        }
        memo[begin][M] = res;
        return res;
    }
}

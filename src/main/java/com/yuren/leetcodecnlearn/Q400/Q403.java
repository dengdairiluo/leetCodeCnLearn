package com.yuren.leetcodecnlearn.Q400;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2021-12-26 20:51
 */
public class Q403 {
    public boolean canCross(int[] stones) {
        // 第一个点都跳不上去
        if (stones[1] != 1) {
            return false;
        }
        // 跳上去了 ,就两个长度
        if (stones.length == 2) {
            return true;
        }
        int len = stones.length;
        Boolean[][] dp = new Boolean[len][len];
        // 经过k步 抵达当前位置 能否到达最后
        return this.canCross(stones, 1, 1, dp);
    }

    private boolean canCross(int[] stones, int k, int first, Boolean[][] dp) {
        int last = stones.length - 1;
        if (first == last) {
            return true;
        }
        if (dp[k][first] != null) {
            return dp[k][first];
        }
        for (int i = k - 1; i <= k + 1; i++) {
            // 从当前位置, 经过k-1, k , k+1的尝试能去哪
            int to = stones[first] + i;
            for (int j = first + 1; j <= last && stones[j] <= to; j++) {
                // 能去的位置恰巧存在
                if (stones[j] == to) {
                    // 后续还能走到头
                    if (this.canCross(stones, i, j, dp)) {
                        dp[k][first] = true;
                        // 这条路对了
                        return true;
                    }
                }
            }
        }
        dp[k][first] = false;
        return false;
    }
}

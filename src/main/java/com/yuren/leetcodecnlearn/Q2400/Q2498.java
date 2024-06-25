package com.yuren.leetcodecnlearn.Q2400;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-06-25 下午11:48
 */
public class Q2498 {
    public int maxJump(int[] stones) {
        int cost = stones[1] - stones[0];
        int n = stones.length;
        for (int i = 2; i < n; i++) {
            cost = Math.max(cost, stones[i] - stones[i - 2]);
        }
        return cost;
    }

}

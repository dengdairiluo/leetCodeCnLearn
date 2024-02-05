package com.yuren.leetcodecnlearn.Q2200;

import java.util.List;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-02-05 21:41
 */
public class Q2218 {
    public int maxValueOfCoins(List<List<Integer>> piles, int k) {

        int[] dp = new int[k + 1];
        int sumPileSize = 0;

        for (List<Integer> pile : piles) {

            int n = Math.min(pile.size(), k);
            int[] preSum = new int[n + 1];
            int sum = 0;
            for (int i = 0; i < n; ++i) {
                sum += pile.get(i);
                preSum[i + 1] = sum;
            }

            sumPileSize += n;

            for (int i = Math.min(k, sumPileSize); i > 0; --i) {
                int cur = dp[i];
                for (int j = Math.min(n, i); j > 0; --j) {
                    cur = Math.max(cur, dp[i - j] + preSum[j]);
                }
                dp[i] = cur;
            }

        }
        return dp[k];

    }
}

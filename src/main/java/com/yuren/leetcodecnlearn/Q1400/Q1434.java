package com.yuren.leetcodecnlearn.Q1400;

import java.util.List;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-03-07 23:27
 */
public class Q1434 {
    public int numberWays(List<List<Integer>> hats) {
        int[] hash = new int[41];

        for (int i = 0; i < hats.size(); i++) {
            for (Integer hh : hats.get(i)) {
                hash[hh] |= (1 << i);
            }
        }
        int n = 1 << hats.size();
        int[][] dp = new int[41][n];
        dp[0][0] = 1;
        for (int i = 1; i <= 40; i++) {
            int h = hash[i];
            for (int k = 0; k < n; k++) {
                dp[i][k] = dp[i - 1][k];
            }
            for (int j = 0; j < hats.size(); j++) {
                int hh = 1 << j;
                if ((h & hh) == 0) {
                    continue;
                }
                int m = (~hh) & (n - 1);
                for (int k = m; k > 0; k = (k - 1) & m) {
                    dp[i][k | hh] = (dp[i][k | hh] + dp[i - 1][k]) % 1000000007;
                }
                dp[i][hh] = (dp[i][hh] + dp[i - 1][0]) % 1000000007;
            }


        }
        return dp[40][n - 1];
    }
}

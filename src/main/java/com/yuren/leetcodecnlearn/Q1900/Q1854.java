package com.yuren.leetcodecnlearn.Q1900;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2021-05-14 23:08
 */
public class Q1854 {
    public int maximumPopulation(int[][] logs) {
        int[] dp = new int[101];
        for (int[] log : logs) {
            dp[log[0] - 1950]++;
            dp[log[1] - 1950]--;
        }

        int max = 0, ans = 0;

        for (int i = 0, cnt = 0; i <= 100; i++) {
            cnt += dp[i];
            if (cnt > max) {
                max = cnt;
                ans = i;
            }
        }

        return ans + 1950;
    }

}

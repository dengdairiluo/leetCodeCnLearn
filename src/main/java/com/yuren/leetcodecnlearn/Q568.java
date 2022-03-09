package com.yuren.leetcodecnlearn;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-03-09 22:58
 */
public class Q568 {
    public int maxVacationDays(int[][] flights, int[][] days) {
        if (days.length == 0 || flights.length == 0) {
            return 0;
        }
        int[][] dp = new int[days.length][days[0].length + 1];
        for (int week = days[0].length - 1; week >= 0; week--) {
            for (int curCity = 0; curCity < days.length; curCity++) {
                dp[curCity][week] = days[curCity][week] + dp[curCity][week + 1];
                for (int destCity = 0; destCity < days.length; destCity++) {
                    if (flights[curCity][destCity] == 1) {
                        dp[curCity][week] = Math.max(days[destCity][week] + dp[destCity][week + 1], dp[curCity][week]);
                    }
                }
            }
        }
        return dp[0][0];
    }
}

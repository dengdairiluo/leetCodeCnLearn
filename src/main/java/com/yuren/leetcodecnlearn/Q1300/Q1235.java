package com.yuren.leetcodecnlearn.Q1300;

import java.util.Arrays;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-12-26 06:01
 */
public class Q1235 {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        Work[] works = new Work[endTime.length];
        for (int i = 0; i < works.length; i++) {
            works[i] = new Work(startTime[i], endTime[i], profit[i]);
        }
        Arrays.sort(works);
        int[] dp = new int[works.length + 1];
        dp[0] = 0;
        for (int i = 1; i <= works.length; i++) {
            int pre = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (works[j].endTime <= works[i - 1].startTime) {
                    pre = j + 1;
                    break;
                }
            }
            dp[i] = Math.max(dp[i - 1], dp[pre] + works[i - 1].profit);
        }
        return dp[works.length];
    }

    /**
     * 兼职工作实体类
     */
    private static class Work implements Comparable<Work> {
        public int startTime, endTime, profit;

        public Work(int startTime, int endTime, int profit) {
            this.startTime = startTime;
            this.endTime = endTime;
            this.profit = profit;
        }

        public int compareTo(Work other) {
            return Integer.compare(this.endTime, other.endTime);
        }
    }
}

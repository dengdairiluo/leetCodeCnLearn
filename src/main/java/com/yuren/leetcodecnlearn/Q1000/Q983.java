package com.yuren.leetcodecnlearn.Q1000;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-09-07 23:51
 */
public class Q983 {
    public int minCostTickets(int[] days, int[] costs) {
        int len = days.length;
        int maxDay = days[len - 1];
        int minDay = days[0];
        // 多扩几天，省得判断 365 的限制
        int[] dp = new int[maxDay + 31];
        // 只需看 maxDay -> minDay，此区间外都不需要出门，不会增加费用
        for (int d = maxDay, i = len - 1; d >= minDay; d--) {
            // i 表示 days 的索引
            // 也可提前将所有 days 放入 Set，再通过 set.contains() 判断
            if (d == days[i]) {
                dp[d] = Math.min(dp[d + 1] + costs[0], dp[d + 7] + costs[1]);
                dp[d] = Math.min(dp[d], dp[d + 30] + costs[2]);
                i--; // 别忘了递减一天
            // 不需要出门
            } else {
                dp[d] = dp[d + 1];
            }
        }
        // 从后向前遍历，返回最前的 minDay
        return dp[minDay];
    }
}

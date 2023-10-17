package com.yuren.leetcodecnlearn.Q1900;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-10-18 00:16
 */
public class Q1997 {
    public int firstDayBeenInAllRooms(int[] nextVisit) {
        //dp[i]表示第一次到达i时用的天数
        long[] dp = new long[nextVisit.length];
        dp[0] = 0;//第一次到达0需要0天
        int mod = 1000000007;
        for (int i = 1; i < nextVisit.length; i++) {
            // dp[i - 1]表示第一次到达i-1结点,由于是第一次所以下一步不能到i
            // +1 表示从i-1到达了nextVisit[i - 1]结点,此时相当于第一次到达该结点
            //+(dp[i - 1] - dp[nextVisit[i - 1]])表示从nextVisit[i - 1]到i - 1需要的天数
            // +1 表示从i-1 到 i
            // 注意:这里相减可能会出现负数,所以加上mod
            dp[i] = (mod + dp[i - 1] + 1 + (dp[i - 1] - dp[nextVisit[i - 1]]) + 1) % mod;
        }
        return (int) dp[dp.length - 1];
    }


}

package com.yuren.leetcodecnlearn.Q2000;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-11-25 22:20
 */
public class Q2073 {
    // 队列
    public int timeRequiredToBuy(int[] tickets, int k) {
        int i = 0;
        int time = 0;
        // 当排队人数为1时，完成买票需要的时间等于需要购买的票数
        if (tickets.length == 1) {
            return tickets[0];
        }
        while (tickets[k] != 0) {
            // 去除已经完成购票的人
            if (tickets[i] > 0) {
                tickets[i]--;
                time++;
            }
            i++;
            // 重新让第一个人买票
            if (i == tickets.length) {
                i = 0;
            }
        }
        return time;
    }
}

package com.yuren.leetcodecnlearn.Q1800;

import java.util.PriorityQueue;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-07-27 22:50
 */
public class Q1801 {
    public final int MOD = 1000 * 1000 * 1000 + 7;

    public int getNumberOfBacklogOrders(int[][] orders) {
        PriorityQueue<int[]> minSell = new PriorityQueue<>((i1, i2) -> i1[0] - i2[0]);
        PriorityQueue<int[]> maxBuy = new PriorityQueue<>((i1, i2) -> i2[0] - i1[0]);
        for (int[] o : orders) {
            if (o[2] == 0) {
                while (!minSell.isEmpty() && minSell.peek()[0] <= o[0] && o[1] > 0) {
                    int[] sell = minSell.peek();
                    int min = Math.min(sell[1], o[1]);
                    o[1] -= min;
                    sell[1] -= min;
                    if (sell[1] == 0) {
                        minSell.poll();
                    }
                }
                if (o[1] > 0) {
                    maxBuy.add(o);
                }
            } else {
                while (!maxBuy.isEmpty() && maxBuy.peek()[0] >= o[0] && o[1] > 0) {
                    int[] buy = maxBuy.peek();
                    int min = Math.min(buy[1], o[1]);
                    o[1] -= min;
                    buy[1] -= min;
                    if (buy[1] == 0) {
                        maxBuy.poll();
                    }
                }
                if (o[1] > 0) {
                    minSell.add(o);
                }
            }
        }

        int result = 0;
        for (int[] o : orders) {
            result = (result + o[1]) % MOD;
        }
        return result;
    }
}

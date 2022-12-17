package com.yuren.leetcodecnlearn.Q1000;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-08-01 23:09
 */
public class Q901 {
    int[][] stk = new int[2][10010];
    int t = 0, day = 0;

    public Q901() {
        stk[0][++t] = Integer.MAX_VALUE;
        stk[1][t] = day++;
    }

    public int next(int price) {
        while (stk[0][t] <= price) {
            t--;
        }
        int res = day - stk[1][t];
        stk[0][++t] = price;
        stk[1][t] = day++;
        return res;
    }
}

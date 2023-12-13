package com.yuren.leetcodecnlearn.Q2100;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-12-13 22:33
 */
public class Q2110 {
    public long getDescentPeriods(int[] prices) {
        long n = prices.length;
        int j = prices.length, pn = 0;
        for (int i = 1; i < j; i++) {
            if (prices[i - 1] - 1 == prices[i]) {
                pn++;
                n += pn;
            } else {
                pn = 0;
            }
        }
        return n;
    }
}

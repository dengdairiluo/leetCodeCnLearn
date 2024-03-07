package com.yuren.leetcodecnlearn.Q2200;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-03-07 23:09
 */
public class Q2280 {
    public int minimumLines(int[][] stockPrices) {
        int n = stockPrices.length;
        if (n == 1) return 0;
        Arrays.sort(stockPrices, Comparator.comparingInt(a -> a[0]));
        int a = stockPrices[1][0] - stockPrices[0][0];
        int b = stockPrices[1][1] - stockPrices[0][1];
        int res = 1;
        for (int i = 1; i < n - 1; i++) {
            int na = stockPrices[i + 1][0] - stockPrices[i][0];
            int nb = stockPrices[i + 1][1] - stockPrices[i][1];
            if (b * na == a * nb) {
                continue;
            }
            a = na;
            b = nb;
            //System.out.println(a + "-" + b);
            res++;
        }
        return res;
    }
}

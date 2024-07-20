package com.yuren.leetcodecnlearn.Q2500;

import java.util.Arrays;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-07-20 下午11:27
 */
public class Q2548 {
    public double maxPrice(int[][] items, int capacity) {
        double totalPrice = 0;
        Arrays.sort(items, (a, b) -> b[0] * a[1] - a[0] * b[1]);
        int remain = capacity;
        int length = items.length;
        for (int i = 0; i < length && remain > 0; i++) {
            double price = items[i][0];
            int weight = items[i][1];
            int currWeight = Math.min(weight, remain);
            if (currWeight == weight) {
                totalPrice += price;
            } else {
                totalPrice += price / weight * currWeight;
            }
            remain -= currWeight;
        }
        return remain == 0 ? totalPrice : -1;
    }
}

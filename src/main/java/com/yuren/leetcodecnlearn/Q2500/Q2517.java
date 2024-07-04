package com.yuren.leetcodecnlearn.Q2500;

import java.util.Arrays;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-07-04 下午11:56
 */
public class Q2517 {
    private int check(int d, int[] price) {
        int cnt = 1;
        int pre = price[0];
        for (int p : price) {
            if (p >= pre + d) {
                cnt++;
                pre = p;
            }
        }
        return cnt;
    }

    public int maximumTastiness(int[] price, int k) {
        Arrays.sort(price);
        int left = 0;
        int right = (price[price.length - 1] - price[0]) / (k - 1) + 1;
        while (left + 1 < right) {
            int mid = (right - left) / 2 + left;
            if (check(mid, price) >= k) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return left;
    }
}

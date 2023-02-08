package com.yuren.leetcodecnlearn.Q1400;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-02-08 23:45
 */
public class Q1359 {
    public int countOrders(int n) {
        long ans = 1;
        long mod = (long) (1e9 + 7);
        for (int i = 2; i <= n; i++) {
            ans *= (2 * i * i - i);
            ans %= mod;
        }
        return (int) ans;
    }
}

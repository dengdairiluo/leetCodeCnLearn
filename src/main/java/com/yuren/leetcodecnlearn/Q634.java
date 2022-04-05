package com.yuren.leetcodecnlearn;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-04-06 06:18
 */
public class Q634 {
    public int findDerangement(int n) {
        long mul = 1, sum = 0, M = 1000000007;
        for (int i = n; i >= 0; i--) {
            sum = (sum + M + mul * (i % 2 == 0 ? 1 : -1)) % M;
            mul = (mul * i) % M;
        }
        return (int) sum;
    }
}

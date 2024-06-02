package com.yuren.leetcodecnlearn.Q2400;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-06-02 下午11:33
 */
public class Q2450 {
    static final int MODULO = 1000000007;

    public int countDistinctStrings(String s, int k) {
        return (int) power(2, s.length() - k + 1);
    }

    public long power(long x, int n) {
        if (n == 0) {
            return 1;
        }
        if (x == 0) {
            return 0;
        }
        long power = 1;
        long baseNum = x;
        while (n != 0) {
            if (n % 2 != 0) {
                power = power * baseNum % MODULO;
            }
            baseNum = baseNum * baseNum % MODULO;
            n /= 2;
        }
        return power;
    }
}

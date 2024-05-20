package com.yuren.leetcodecnlearn.Q2400;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-05-20 下午11:59
 */
public class Q2427 {
    public int commonFactors(int a, int b) {
        int ans = 0, g = gcd(a, b);
        for (int i = 1; i * i <= g; ++i)
            if (g % i == 0) {
                ++ans; // i 是公因子
                if (i * i < g)
                    ++ans; // g/i 是公因子
            }
        return ans;
    }

    private int gcd(int a, int b) {
        while (a != 0) {
            int tmp = a;
            a = b % a;
            b = tmp;
        }
        return b;
    }
}

package com.yuren.leetcodecnlearn.Q1400;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-03-28 23:50
 */
public class Q1492 {
    public int kthFactor(int n, int k) {
        int count = 0, factor;
        for (factor = 1; factor * factor <= n; ++factor) {
            if (n % factor == 0) {
                ++count;
                if (count == k) {
                    return factor;
                }
            }
        }
        --factor;
        if (factor * factor == n) {
            --factor;
        }
        for (; factor > 0; --factor) {
            if (n % factor == 0) {
                ++count;
                if (count == k) {
                    return n / factor;
                }
            }
        }
        return -1;
    }
}

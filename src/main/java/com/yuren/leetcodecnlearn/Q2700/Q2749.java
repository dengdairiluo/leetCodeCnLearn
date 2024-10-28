package com.yuren.leetcodecnlearn.Q2700;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author 10204
 * @date 2024-10-28 23:53
 */
public class Q2749 {
    public int makeTheIntegerZero(int n1, int n2) {
        for (long k = 1; k <= n1 - n2 * k; k++)
            if (k >= Long.bitCount(n1 - n2 * k))
                return (int) k;
        return -1;
    }
}

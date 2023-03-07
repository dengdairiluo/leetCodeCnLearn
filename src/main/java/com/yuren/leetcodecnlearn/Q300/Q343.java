package com.yuren.leetcodecnlearn.Q300;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2021-12-03 23:40
 */
public class Q343 {
    public int integerBreak(int n) {
        int p = n % 3, q = n / 3, r = p + (2 * p + 1) % 5;
        return n <= 3 ? n - 1 : (int) (Math.pow(3, q - (p & 1)) * r);
    }
}

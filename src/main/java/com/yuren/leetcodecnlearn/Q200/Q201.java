package com.yuren.leetcodecnlearn.Q200;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2021-10-12 22:01
 */
public class Q201 {
    public int rangeBitwiseAnd(int m, int n) {
        if (m == n) {
            return m;
        }
        int a = ~(n ^ m);
        a &= a >> 1;
        a &= a >> 2;
        a &= a >> 4;
        a &= a >> 8;
        a &= a >> 16;
        return m & a;
    }
}

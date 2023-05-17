package com.yuren.leetcodecnlearn.Q1600;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-05-17 23:38
 */
public class Q1611 {
    public int minimumOneBitOperations(int n) {
        int res = 0;
        while (n != 0) {
            res ^= n;
            n >>= 1;
        }
        return res;
    }
}

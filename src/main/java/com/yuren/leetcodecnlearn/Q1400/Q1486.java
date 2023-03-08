package com.yuren.leetcodecnlearn.Q1400;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2021-01-01 20:01
 */
public class Q1486 {
    public int xorOperation(int n, int start) {
        int result = start, i;
        for (i = 1; i < n; i++) {
            result = result ^ (start + i * 2);
        }
        return result;
    }
}

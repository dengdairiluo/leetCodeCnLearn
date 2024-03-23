package com.yuren.leetcodecnlearn.Q2300;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-03-24 01:45
 */
public class Q2310 {
    public int minimumNumbers(int num, int k) {
        if (num == 0) return 0;
        for (int n = 1; n <= 10 && num - k * n >= 0; ++n) {
            if ((num - k * n) % 10 == 0) {
                return n;
            }
        }
        return -1;
    }
}

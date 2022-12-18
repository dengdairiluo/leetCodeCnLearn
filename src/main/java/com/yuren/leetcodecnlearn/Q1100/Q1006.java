package com.yuren.leetcodecnlearn.Q1100;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-09-17 23:55
 */
public class Q1006 {
    public int clumsy(int n) {
        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        } else if (n == 3) {
            return 6;
        } else if (n == 4) {
            return 7;
        }

        if (n % 4 == 0) {
            return n + 1;
        } else if (n % 4 <= 2) {
            return n + 2;
        } else {
            return n - 1;
        }
    }
}

package com.yuren.leetcodecnlearn.Q1800;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-07-29 22:32
 */
public class Q1806 {
    public int reinitializePermutation(int n) {
        if (n == 2) {
            return 1;
        }
        int tmp = 1, cnt = 0;
        do {
            tmp = tmp % 2 == 0 ? tmp / 2 : n / 2 + (tmp - 1) / 2;
            cnt++;
        } while (tmp != 1);
        return cnt;
    }
}

package com.yuren.leetcodecnlearn;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2021-04-06 23:09
 */
public class Q1134 {
    public boolean isArmstrong(int n) {
        int tmp = n, sum = 0;
        int k = String.valueOf(n).length();
        for (int i = 0; i < k; i++) {
            sum += Math.pow(tmp%10, k);
            tmp /= 10;
        }
        return sum == n;

    }
}

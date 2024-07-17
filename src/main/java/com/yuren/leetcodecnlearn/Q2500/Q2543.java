package com.yuren.leetcodecnlearn.Q2500;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-07-17 下午11:43
 */
public class Q2543 {
    public boolean isReachable(int targetX, int targetY) {
        int divisor = gcd(targetX, targetY);
        return (divisor & (divisor - 1)) == 0;
    }

    public int gcd(int num1, int num2) {
        while (num2 != 0) {
            int temp = num1;
            num1 = num2;
            num2 = temp % num2;
        }
        return num1;
    }
}

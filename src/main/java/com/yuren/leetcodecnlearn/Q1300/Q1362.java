package com.yuren.leetcodecnlearn.Q1300;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-02-09 23:52
 */
public class Q1362 {
    public int[] closestDivisors(int num) {
        int divisor = num == 1 ? num + 1 : num + 2;
        int i = (int) Math.sqrt(divisor);
        while (divisor % i > 1) {
            i--;
        }
        return new int[]{i, divisor / i};
    }
}

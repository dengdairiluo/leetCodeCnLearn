package com.yuren.leetcodecnlearn;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2021-04-07 23:18
 */
public class Q1085 {
    public int sumOfDigits(int[] A) {
        int min = A[0];
        for (int n : A) {
            if (n < min) {
                min = n;
            }
        }
        int sum = 0;
        int n = 0;
        while (min != 0) {
            n = min % 10;
            sum += n;
            min = min / 10;
        }
        return sum % 2 == 0 ? 1 : 0;
    }
}

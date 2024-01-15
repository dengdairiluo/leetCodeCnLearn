package com.yuren.leetcodecnlearn.Q2100;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-01-15 22:40
 */
public class Q2177 {
    public long[] sumOfThree(long num) {
        long[] ints = new long[3];
        if (num % 3 == 0) {
            ints[0] = (num / 3) - 1;
            ints[1] = (num / 3);
            ints[2] = (num / 3) + 1;
        }
        return num % 3 == 0 ? ints : new long[0];
    }
}

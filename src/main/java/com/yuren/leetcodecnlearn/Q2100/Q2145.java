package com.yuren.leetcodecnlearn.Q2100;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-12-31 19:17
 */
public class Q2145 {
    public int numberOfArrays(int[] differences, int lower, int upper) {

        long min = differences[0], max = differences[0], sum = differences[0];

        for (int i = 1; i < differences.length; i++) {
            sum += differences[i];
            min = Math.min(min, sum);
            max = Math.max(max, sum);
        }

        long l = min < 0 ? lower + Math.abs(min) : lower;
        long u = max > 0 ? upper - max : upper;

        return Math.max(0, (int) (u - l + 1));
    }
}

package com.yuren.leetcodecnlearn.Q1900;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-09-27 05:55
 */
public class Q1953 {
    public long numberOfWeeks(int[] milestones) {
        long max = 0;
        long sum = 0;
        for (long m : milestones) {
            if (m > max) {
                max = m;
            }
            sum += m;
        }
        long rest = sum - max;
        if (max > rest) {
            return rest * 2 + 1;
        } else {
            return sum;
        }
    }
}

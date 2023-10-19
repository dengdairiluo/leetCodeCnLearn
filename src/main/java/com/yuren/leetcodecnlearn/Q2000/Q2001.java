package com.yuren.leetcodecnlearn.Q2000;

import java.util.HashMap;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-10-19 23:34
 */
public class Q2001 {
    public long interchangeableRectangles(int[][] rectangles) {
        final HashMap<Double, Integer> counter = new HashMap<>();
        for (int[] rect : rectangles) {
            Double key = ((double) rect[0]) / rect[1];
            Integer cnt = counter.get(key);
            if (cnt != null) {
                cnt++;
            } else {
                cnt = 1;
            }
            counter.put(key, cnt);
        }
        long sum = 0;
        for (int val : counter.values()) {
            if (val > 1) {
                sum += ((long) val) * (val - 1) / 2;
            }
        }
        return sum;
    }
}

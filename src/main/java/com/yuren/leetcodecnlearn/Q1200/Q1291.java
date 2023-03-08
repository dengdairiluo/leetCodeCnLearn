package com.yuren.leetcodecnlearn.Q1200;

import java.util.LinkedList;
import java.util.List;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-01-15 23:01
 */
public class Q1291 {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> result = new LinkedList<>();

        for (int m = 2; m <= 9 && Math.pow(10, m - 1) < high; m++) {
            for (int i = 1; i <= 8; i++) {
                int value = i;
                int j = i;
                while (++j - i < m && j < 10) {
                    value = value * 10 + j;
                }
                if (j - i == m && value >= low && value <= high) {
                    result.add(value);
                } else if (value > high) {
                    break;
                }
            }
        }

        return result;
    }
}

package com.yuren.leetcodecnlearn.Q1300;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-02-14 23:50
 */
public class Q1375 {
    public int numTimesAllBlue(int[] flips) {
        int max = 0;
        int count = 0;
        for (int i = 0; i < flips.length; i++) {
            int number = flips[i];
            if (number > max) {
                max = number;
            }
            if (max == i + 1) {
                count += 1;
            }
        }
        return count;
    }
}

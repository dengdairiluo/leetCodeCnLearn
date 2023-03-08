package com.yuren.leetcodecnlearn.Q1100;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-11-15 23:44
 */
public class Q1151 {
    public int minSwaps(int[] data) {
        int total = 0;
        for (int i : data) {
            total += i;
        }
        int first = 0;
        for (int i = 0; i < total; i++) {
            first += data[i];
        }
        int max = first;
        int cur = first;
        for (int i = total; i < data.length; i++) {
            cur += data[i] - data[i - total];
            if (cur > max) {
                max = cur;
            }
        }
        return total - max;
    }
}

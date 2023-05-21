package com.yuren.leetcodecnlearn.Q1600;

import java.util.Arrays;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-05-21 23:04
 */
public class Q1619 {
    public double trimMean(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length, tot = 0;
        for (int i = n / 20; i < n - n / 20; i++) {
            tot += arr[i];
        }
        return tot * 1.0 / (n * 0.9);
    }
}

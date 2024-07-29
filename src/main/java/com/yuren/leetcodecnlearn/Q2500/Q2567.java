package com.yuren.leetcodecnlearn.Q2500;

import java.util.Arrays;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-07-29 下午11:59
 */
public class Q2567 {
    public int minimizeSum(int[] a) {
        Arrays.sort(a);
        int n = a.length;
        return Math.min(Math.min(a[n - 3] - a[0], a[n - 2] - a[1]), a[n - 1] - a[2]);
    }
}

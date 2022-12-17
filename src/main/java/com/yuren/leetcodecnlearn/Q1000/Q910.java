package com.yuren.leetcodecnlearn.Q1000;

import java.util.Arrays;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-08-07 22:35
 */
public class Q910 {
    public int smallestRangeII(int[] arr, int k) {
        int N = arr.length;
        Arrays.sort(arr);
        int ans = arr[N - 1] - arr[0];

        for (int i = 0; i < arr.length - 1; ++i) {
            int a = arr[i], b = arr[i + 1];
            int high = Math.max(arr[N - 1] - k, a + k);
            int low = Math.min(arr[0] + k, b - k);
            ans = Math.min(ans, high - low);
        }
        return ans;
    }
}

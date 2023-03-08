package com.yuren.leetcodecnlearn.Q1300;

import java.util.Arrays;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-01-31 00:24
 */
public class Q1338 {
    public int minSetSize(int[] arr) {
        int[] count = new int[100001];
        int[] index = new int[arr.length];
        int p = 0;
        for (int i : arr) {
            int current = count[i];
            if (0 == current) {
                count[i] = 1;
                index[p++] = i;
            } else {
                count[i] = current + 1;
            }
        }
        for (int i = 0; i < p; i++) {
            arr[i] = count[index[i]];
        }
        Arrays.sort(arr, 0, p);
        int sum = 0;
        int half = arr.length / 2;
        for (int i = p - 1; i >= 0; i--) {
            sum += arr[i];
            if (sum >= half) return p - i;
        }
        return 0;
    }
}

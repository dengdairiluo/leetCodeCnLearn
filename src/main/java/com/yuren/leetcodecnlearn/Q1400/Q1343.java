package com.yuren.leetcodecnlearn.Q1400;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-02-02 00:35
 */
public class Q1343 {
    public static int numOfSubArrays(int[] arr, int k, int threshold) {
        int sum = 0, result = 0;
        int sumTarget = k * threshold;
        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }
        int adder = sum - sumTarget;
        if (adder >= 0) {
            result++;
        }
        int pos = k;
        for (int i = 0; i < arr.length - k; i++) {
            adder = adder + arr[pos] - arr[i];
            if (adder >= 0) {
                result++;
            }
            pos++;
        }
        return result;
    }
}

package com.yuren.leetcodecnlearn.Q1400;

import java.util.Arrays;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-03-21 23:50
 */
public class Q1471 {
    public int[] getStrongest(int[] arr, int k) {
        int[] strongest = new int[k];
        Arrays.sort(arr);
        int n = arr.length;
        int m = arr[(n - 1) / 2];
        int left = 0, right = n - 1;
        for (int i = 0; i < k; i++) {
            if (compare(arr[left], arr[right], m) > 0) {
                strongest[i] = arr[left];
                left++;
            } else {
                strongest[i] = arr[right];
                right--;
            }
        }
        return strongest;
    }

    public int compare(int num1, int num2, int m) {
        int diff1 = Math.abs(num1 - m);
        int diff2 = Math.abs(num2 - m);
        if (diff1 != diff2) {
            return diff1 - diff2;
        } else {
            return num1 - num2;
        }
    }
}

package com.yuren.leetcodecnlearn.Q1100;

import java.util.Arrays;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2022-10-15 23:48
 */
public class Q1073 {
    public int[] addNegabinary(int[] arr1, int[] arr2) {
        int max = Math.max(arr1.length, arr2.length);
        int[] result = new int[max + 2];
        int index = result.length - 1, carry = 0;
        for (int i = 0; i < result.length; i++) {
            int a1 = i < arr1.length ? arr1[arr1.length - 1 - i] : 0;
            int a2 = i < arr2.length ? arr2[arr2.length - 1 - i] : 0;

            int sum = a1 + a2 + carry;
            result[index--] = sum & 1;
            carry = -(sum >> 1);
        }
        int notZero = 0;
        while (notZero < result.length - 1 && result[notZero] == 0) {
            notZero++;
        }
        return Arrays.copyOfRange(result, notZero, result.length);
    }
}

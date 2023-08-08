package com.yuren.leetcodecnlearn.Q1800;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-08-08 23:43
 */
public class Q1835 {
    public int getXORSum(int[] arr1, int[] arr2) {
        int sum1 = 0;
        int sum2 = 0;
        for (int i : arr1) {
            sum1 ^= i;
        }
        for (int i : arr2) {
            sum2 ^= i;
        }
        return sum1 & sum2;
    }
}

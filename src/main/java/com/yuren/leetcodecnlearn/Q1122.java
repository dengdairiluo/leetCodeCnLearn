package com.yuren.leetcodecnlearn;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2021-05-28 23:46
 */
public class Q1122 {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int upper = 0;
        for (int x : arr1) {
            upper = Math.max(upper, x);
        }
        int[] frequency = new int[upper + 1];
        for (int x : arr1) {
            ++frequency[x];
        }
        int[] ans = new int[arr1.length];
        int index = 0;
        for (int x : arr2) {
            for (int i = 0; i < frequency[x]; ++i) {
                ans[index++] = x;
            }
            frequency[x] = 0;
        }
        for (int x = 0; x <= upper; ++x) {
            for (int i = 0; i < frequency[x]; ++i) {
                ans[index++] = x;
            }
        }
        return ans;
    }
}

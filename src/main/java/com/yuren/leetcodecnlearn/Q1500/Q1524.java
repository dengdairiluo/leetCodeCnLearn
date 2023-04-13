package com.yuren.leetcodecnlearn.Q1500;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-04-13 23:46
 */
public class Q1524 {
    private static final int M = 1000000007;

    public int numOfSubarrays(int[] arr) {
        long r = 0;
        int[] s = new int[]{1, 0};
        for (int i = 0, sum = 0; i < arr.length; i++) {
            ++s[sum ^= arr[i] & 1];
            r += s[sum ^ 1];
        }
        return (int) (r % M);
    }
}

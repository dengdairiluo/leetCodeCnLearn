package com.yuren.leetcodecnlearn.Q1800;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-08-18 23:21
 */
public class Q1862 {
    private static final int mod = (int) 1e9 + 7;

    public int sumOfFlooredPairs(int[] nums) {

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int x : nums) {
            if (x > max) max = x;
            if (x < min) min = x;
        }

        int[] count = new int[max + 1];

        for (int x : nums) {
            ++count[x];
        }

        long[] suffixSum = new long[max + 2];
        long sum = 0;
        for (int i = max; i >= min; --i) {
            sum += count[i];
            suffixSum[i] = sum;
        }

        long result = 0;
        for (int i = min; i <= max; ++i) {
            if (count[i] == 0) {
                continue;
            }
            sum = 0;
            for (int j = i; j <= max; j += i) {
                sum += suffixSum[j];
            }
            result += sum * count[i];
        }

        return (int) (result % mod);
    }
}

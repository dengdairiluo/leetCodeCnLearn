package com.yuren.leetcodecnlearn.Q1200;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-01-12 00:44
 */
public class Q1283 {
    public int smallestDivisor(int[] nums, int threshold) {
        int l = 0, r = (int) 1e6 + 1;
        while (l + 1 < r) {
            int c = l + (r - l) / 2;
            if (getThreshold(nums, c) <= threshold) {
                r = c;
            } else {
                l = c;
            }
        }
        return r;
    }

    private int getThreshold(int[] nums, int c) {
        int sum = 0;
        for (int x : nums) {
            sum += (x - 1) / c + 1;
        }
        return sum;
    }
}

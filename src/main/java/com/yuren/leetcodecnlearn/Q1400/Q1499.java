package com.yuren.leetcodecnlearn.Q1400;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-04-02 03:16
 */
public class Q1499 {
    public int findMaxValueOfEquation(int[][] points, int k) {

        int n = points.length;
        int left = 0, right = 1, result = Integer.MIN_VALUE;

        while (left < right && right < n) {

            int delta = points[right][0] - points[left][0];

            if (delta > k) {
                ++left;
            } else {
                int sum = points[right][1] + points[left][1] + delta;
                if (result < sum) {
                    result = sum;
                }
                if (right == n - 1 || points[right][1] >= points[left][1] + delta) {
                    ++left;
                } else {
                    ++right;
                }
            }
            if (right == left) {
                ++right;
            }

        }

        return result;
    }
}

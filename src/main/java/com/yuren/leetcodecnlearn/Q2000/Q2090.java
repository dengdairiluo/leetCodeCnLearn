package com.yuren.leetcodecnlearn.Q2000;

import java.util.Arrays;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-12-02 23:33
 */
public class Q2090 {
    public int[] getAverages(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n];
        if (k == 0) {
            return nums;
        }
        if (n <= 2 * k) {
            Arrays.fill(res, -1);
        } else {
            for (int i = 0; i < k; i++) {
                res[i] = -1;
            }
            for (int i = n - k; i < n; i++) {
                res[i] = -1;
            }
            long sum = 0L;
            for (int i = 0; i < 2 * k + 1; i++) {
                sum += (long) nums[i];
            }
            for (int i = k; i < n - k; i++) {
                res[i] = (int) (sum / (2 * k + 1));
                if (i + 1 + k < n) {
                    sum += (long) (nums[i + k + 1] - nums[i - k]);
                }
            }
        }
        return res;
    }
}

package com.yuren.leetcodecnlearn.Q1400;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-03-05 22:21
 */
public class Q1425 {
    public int constrainedSubsetSum(int[] nums, int k) {
        int n = nums.length;
        int max = Integer.MIN_VALUE;
        int[] q = new int[n];
        int hh = 0, tt = -1;
        int[] f = new int[n];
        for (int i = 0; i < n; i++) {
            f[i] = nums[i];
            while (hh <= tt && i - q[hh] > k) {
                hh++;
            }
            if (hh <= tt && f[q[hh]] > 0) {
                f[i] += f[q[hh]];
            }
            while (hh <= tt && f[q[tt]] <= f[i]) {
                tt--;
            }
            q[++tt] = i;
            max = Math.max(max, f[i]);
        }
        return max;
    }
}

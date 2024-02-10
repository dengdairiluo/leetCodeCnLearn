package com.yuren.leetcodecnlearn.Q2200;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2024-02-10 20:23
 */
public class Q2229 {
    public boolean isConsecutive(int[] nums) {
        int nmin = Integer.MAX_VALUE;
        for (int n : nums) nmin = Math.min(nmin, n);
        int[] counts = new int[nums.length];
        for (int n : nums) {
            if (n - nmin >= nums.length) return false;
            if (++counts[n - nmin] > 1) return false;
        }
        return true;
    }
}

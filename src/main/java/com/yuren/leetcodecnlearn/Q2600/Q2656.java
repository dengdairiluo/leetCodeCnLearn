package com.yuren.leetcodecnlearn.Q2600;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author 10204
 * @date 2024-09-12 23:48
 */
public class Q2656 {
    public int maximizeSum(int[] nums, int k) {
        int m = 0;
        for (int x : nums) {
            m = Math.max(m, x);
        }
        return (m * 2 + k - 1) * k / 2;
    }
}

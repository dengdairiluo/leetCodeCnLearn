package com.yuren.leetcodecnlearn.Q1200;

/**
 * Created with Intellij IDEA.
 * Description:
 *
 * @author lujiang
 * @date 2023-01-05 00:12
 */
public class Q1250 {
    public boolean isGoodArray(int[] nums) {
        int len = nums.length, res = nums[0];
        for (int i = 1; i < len; i++) {
            res = gcd(res, nums[i]);
        }
        return res == 1;
    }

    public static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

}
